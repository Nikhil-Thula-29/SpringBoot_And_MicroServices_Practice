package com.nt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.nt.entity.JobSeekerInfo;
import com.nt.model.JobSeekerDetails;
import com.nt.service.IJobSeekerManagementService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@MultipartConfig
public class JobSeekerOperationsController {

	@Autowired
	private IJobSeekerManagementService serv;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/")
	public String showHome() {
		return "welcome";
	}
	
	@GetMapping("/js_register")
	public String showFormPage(@ModelAttribute("jsdet") JobSeekerDetails details) {
		return "js_register_form";
	}
	
	@PostMapping("/js_register")
	public String registerJobSeeker(Map<String,Object> map,@ModelAttribute("jsdet") JobSeekerDetails details) throws Exception{
		//get folder location of file uploading from the application properties file
		String storeLocation=env.getRequiredProperty("spring.servlet.multipart.location");
		//create storeLocation folder if it is not already there
		File storeLocationFolder=new File(storeLocation);
		if(!storeLocationFolder.exists()) {
			storeLocationFolder.mkdir();
		}
		
		//get MimeMultiPart Objects from the uploaded files
		MultipartFile file1=details.getResume();
		MultipartFile file2=details.getPhoto();
		//create InputStream from the MultipartFile Objects
		InputStream file1Is=file1.getInputStream();
		InputStream file2Is=file2.getInputStream();
		//get original file names from the list of uploaded files
		String fileName1=file1.getOriginalFilename();	//eg:like resume.txt
		String fileName2=file2.getOriginalFilename();
		//create outstreams having destination file names
		OutputStream file1Os=new FileOutputStream(storeLocationFolder.getAbsolutePath()+"/"+fileName1);
		OutputStream file2Os=new FileOutputStream(storeLocationFolder.getAbsolutePath()+"/"+fileName2);
		//copy the content of uploaded files to Dest files
		IOUtils.copy(file1Is, file1Os);
		IOUtils.copy(file2Is, file2Os);
		//close streams
		file1Is.close();file2Is.close();
		file1Os.close();file2Os.close();
		//create Entity class object having content of model class obj
		JobSeekerInfo info=new JobSeekerInfo();
		info.setJsName(details.getJsName());
		info.setJsAddrs(details.getJsAddrs());
		info.setJsQlfy(details.getJsQlfy());
		info.setPhotoPath(storeLocationFolder.getAbsolutePath()+"/"+fileName2);	//fileName2-->photo
		info.setResumePath(storeLocationFolder.getAbsolutePath()+"/"+fileName1);	//fileName1-->resume
		//use service class
		String resultMsg=serv.saveJobSeeker(info);
		//keep results in model attributes
		map.put("resultMsg", resultMsg);
		map.put("fileName1",fileName1);
		map.put("fileName2", fileName2);
		//return LVN
		return "show_result";
	}
	
	
	@GetMapping("/js_report")
	public String showAllJobSeeker(Map<String,Object> map) {
		List<JobSeekerInfo> list=serv.showAllJobSeekers();
		map.put("jsinfo",list);
		return "show_report";
		
	}
	
	@GetMapping("/download")
	public String downloadFile(@RequestParam("id") Integer id,
								@RequestParam("type") String type,
								HttpServletRequest req,HttpServletResponse res)throws Exception{
		
		String filePath=null;
		if(type.equalsIgnoreCase("resume")) {
			filePath=serv.fetchResumePathById(id);
		}
		else {
			filePath=serv.fetchPhotoPathById(id);
		}
		
		//create java.io.file class obj representing the file to be downloaded
		File file=new File(filePath);
		//get the file length and make it as response content length
		res.setContentLengthLong(file.length());
		//get servletContext object
		ServletContext sc=req.getServletContext();
		//get MIME of the file and make it as the reponse content type
		String mimeType=sc.getMimeType(filePath);
		mimeType=(mimeType==null)?"application/octet-stream":mimeType;	//default mimetype:octet-stream
		res.setContentType(mimeType);
		//create Inputstream obj pointing to the file to db download
		InputStream is=new FileInputStream(file);
		//create outstream obj pointing to the response obj
		OutputStream os=res.getOutputStream();
		//give instructions to browser to display the received content as downloadable file
		res.addHeader("content-Disposition", "attachment;fileName="+file.getName());
		//copy file content to response obj
		IOUtils.copy(is, os);
		//close the streams
		is.close();
		os.close();
		return null;//required if handler wants to send the response/output to browser directly
	}
	
}
