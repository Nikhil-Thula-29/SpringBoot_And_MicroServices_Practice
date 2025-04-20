package com.nt.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Document(collection = "OTM_MEDAL")
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class Medal {

	@Id
	@NonNull
	private Integer mid;
	@NonNull
	private String mType;
	@Override
	public String toString() {
		return "Medal [mid=" + mid + ", mType=" + mType + "]";
	}
}
