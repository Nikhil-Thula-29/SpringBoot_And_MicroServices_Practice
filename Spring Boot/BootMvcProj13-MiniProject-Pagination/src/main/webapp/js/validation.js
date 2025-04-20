
function validation(frm){
	//empty the existing error messages
	document.getElementById('enameErr').innerHTML="";
	document.getElementById('jobErr').innerHTML="";
	document.getElementById('salErr').innerHTML="";
	document.getElementById('deptErr').innerHTML="";
	
	//read the form data
	let name=frm.ename.value;
	console.log(name);
	let job=frm.job.value;
	let sal=frm.sal.value;
	let deptno=frm.deptno.value;
	
	//write the client form validation logic
	let vflag=true;
	debugger
	console.log(vflag);
	if(name==""||name.length==0){
		document.getElementById('enameErr').innerHTML="Employee name is Mandatory(cs)";
		vflag=false;
	}
	else if(name.length<5 || name.length>15){
		document.getElementById('enameErr').innerHTML="Employee name must have minimum of 5 chars and maximum of 15 chars(cs)";
		vflag=false;
	}
	
	if(job==""||job.length==0){
		document.getElementById('jobErr').innerHTML="Employee job is Mandatory(cs)";
		vflag=false;
	}
	else if(job.length<4 || name.length>10){
		document.getElementById('jobErr').innerHTML="Employee job must have minimum of 4 chars and maximum of 10 chars(cs)";
		vflag=false;
	}
	
	
	if(sal==""||sal.length==0){
		document.getElementById('salErr').innerHTML="Employee salary is Mandatory(cs)";
		vflag=false;
	}
	else if(isNaN(sal)){
		document.getElementById('salErr').innerHTML="Employee salary must be numeric value(cs)";
		vflag=false;
	}else if(sal<10000||sal>200000){
		document.getElementById('salErr').innerHTML="Employee salary must be between 10000 and 200000(cs)";
		vflag=false;
	}
	
	if(deptno==""||deptno.length==0){
		document.getElementById('deptErr').innerHTML="Employee deptno is manadatory(cs)";
		vflag=false;
	}
	
	
	//change the hidden box (vflag) value to true indicating that the client side form validations are done
	frm.vflag1.value="yes";
	
	return vflag;
}



/*short hand form or arrow function*/
/*let validation=(frm)=>{
	//empty the existing error messages
	let output=(id)=>document.getElementById(id);
	output('enameErr').innerHTML="";
	output('jobErr').innerHTML="";
	output('salErr').innerHTML="";
	output('deptErr').innerHTML="";
	
	//read the form data
	let name=frm.ename.value;
	console.log(name);
	let job=frm.job.value;
	let sal=frm.sal.value;
	let deptno=frm.deptno.value;
	
	//write the client form validation logic
	let vflag=true;
	debugger
	console.log(vflag);
	if(name==""||name.length==0){
		document.getElementById('enameErr').innerHTML="Employee name is Mandatory(cs)";
		vflag=false;
	}
	else if(name.length<5 || name.length>15){
		document.getElementById('enameErr').innerHTML="Employee name must have minimum of 5 chars and maximum of 15 chars(cs)";
		vflag=false;
	}
	
	if(job==""||job.length==0){
		document.getElementById('jobErr').innerHTML="Employee job is Mandatory(cs)";
		vflag=false;
	}
	else if(job.length<4 || name.length>10){
		document.getElementById('jobErr').innerHTML="Employee job must have minimum of 4 chars and maximum of 10 chars(cs)";
		vflag=false;
	}
	
	
	if(sal==""||sal.length==0){
		document.getElementById('salErr').innerHTML="Employee salary is Mandatory(cs)";
		vflag=false;
	}
	else if(isNaN(sal)){
		document.getElementById('salErr').innerHTML="Employee salary must be numeric value(cs)";
		vflag=false;
	}else if(sal<10000||sal>200000){
		document.getElementById('salErr').innerHTML="Employee salary must be between 10000 and 200000(cs)";
		vflag=false;
	}
	
	if(deptno==""||deptno.length==0){
		document.getElementById('deptErr').innerHTML="Employee deptno is manadatory(cs)";
		vflag=false;
	}
	
	return vflag;
}*/