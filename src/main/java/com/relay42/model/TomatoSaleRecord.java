package com.relay42.model;

import java.time.LocalDate;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Eldjon Kepucka.
 */
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Builder
public class TomatoSaleRecord {

	private String id;
	private String provider;
	private int tomatoes;
	private long timestamp;


	public enum TomatoProvider{

		HEINZ("Heinz"),
		DEL_MONTE("Del Monte"),
		OL_GRAMMA("Le Ol' Gramma");

		private String provider;

		TomatoProvider(String tomatoProvider){
			provider = tomatoProvider;
		}

		public String provider(){
			return provider;
		}
	}
}
