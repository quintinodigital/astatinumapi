package br.com.quintinodigital.astatinumapi.utility;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtility implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String FORMATO_MMYYYY = "MMyyyy";
	public static final String FORMATO_DDMMYYYY = "ddMMyyyy";
	public static final String FORMATO_DDMMYYYYHHMMSS_SEPARADOR = "dd/MM/yyyy HH:mm:ss";
	public static final String FORMATO_DDMMYYYY_SEPARADOR = "dd/MM/yyyy";
	
	public static String recuperarDataFormatada(Date dataReferencia, String formato) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formato);
		return simpleDateFormat.format(dataReferencia);
	}
	
	public static Date gerarDataPorDiaReferencia(Integer diaReferencia, Integer mesReferencia, Date dataReferencia) {
		Calendar calendar = Calendar.getInstance();
			calendar.setTime(dataReferencia);
			calendar.set(Calendar.DAY_OF_MONTH, diaReferencia);
			calendar.set(Calendar.MONTH, mesReferencia);
		return calendar.getTime();
	}
	
	public static Integer recuperarMesDataReferencia(Date dataReferencia) {
		Calendar calendar = Calendar.getInstance();
			calendar.setTime(dataReferencia);
		return calendar.get(Calendar.MONTH);
	}

}
