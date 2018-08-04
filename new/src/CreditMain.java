import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;


public class CreditMain {

	public static void main(String[] args) throws CreditException {
		final String filePath="C:\\Users\\Ronin\\Desktop\\CreditCard\\CreditCard\\cardInputFile.txt";
		CreditMain creditCard=new CreditMain();
		CreditMain.process(filePath);
	}

	public static Map<String, Map<String, CreditVo>> process(String filePath) throws CreditException {
		
		List<String []> inputDataList= readInputFile(filePath);
		Map<String,CreditVo> voMap=valdiateInput(inputDataList);
		
		
		return null;
		
	}

	private static Map<String, CreditVo> valdiateInput(List<String[]> inputDataList) throws CreditException{
		
		CreditVo vo = new CreditVo();
		Map <String, CreditVo> voMap= new HashMap<String, CreditVo>();
		
		String amexCardNo=null;// 16 digit starting with 5
		String visaCardNo=null;// 14 or 15 digit starting with 4 or 5
		String masterCardNo=null;//16 digit starting with 4
		Date dueDate=null;
		Date duePaidDate=null;
		boolean dataFromFileOK=true;
		double billAmount=0.0;
		
		
		for(String[] singleInputRow: inputDataList ) {
			vo=new CreditVo();
			String firstDigitofCard=singleInputRow[0].substring(0, 1);
			
			if(singleInputRow!=null && singleInputRow[0].length()==16){
				if(Integer.parseInt(firstDigitofCard)==5) {
				amexCardNo=singleInputRow[0].substring(0, singleInputRow.length);
				vo.setCardName("Amex");
				vo.setCardNo(amexCardNo);
				}
				else if(Integer.parseInt(firstDigitofCard)==4) {
					masterCardNo=singleInputRow[0].substring(0, singleInputRow.length);
					vo.setCardName("MasterCard");
					vo.setCardNo(masterCardNo);
				}
				else
				{
					dataFromFileOK=false;
					throw new CreditException("Invalid Credit Card no: "+singleInputRow[0].substring(0, singleInputRow.length));
				}
			}
			else if (singleInputRow!=null && (singleInputRow[0].length()==15 || singleInputRow[0].length()==14) && (Integer.parseInt(firstDigitofCard)==5 || Integer.parseInt(firstDigitofCard)==4)) {
				
					visaCardNo=singleInputRow[0].substring(0, singleInputRow.length);
					vo.setCardName("Visa");
					vo.setCardNo(visaCardNo);
					
				
			}
			else {
				dataFromFileOK=false;
				throw new CreditException("Invalid Credit Card no: "+singleInputRow[0].substring(0, singleInputRow.length));
			}
			
			dueDate=validateDueDate(singleInputRow[])
			
			
			
		}
		
		return null;
	}

	private static List<String[]> readInputFile(String filePath) throws CreditException {
		
		String[] inputData= new String [20];
		ArrayList<String[]> dataList=new ArrayList<String[]>();
		
		try {
			
		BufferedReader readInput=new BufferedReader(new FileReader(filePath));
		String singleLinefromInput=null;
		String[] wordsInSingleLine= new String[30];
		
		while((singleLinefromInput=readInput.readLine())!=null) {
			
			if(singleLinefromInput!=null && singleLinefromInput.length()>0) {
				wordsInSingleLine=singleLinefromInput.split("\\|");
								
				dataList.add(wordsInSingleLine);
			}
			}
		/*for(String[] data: dataList) {
			for(int i=0;i<data.length;i++) {
				System.out.println(data[i]);
			}
		}*/
		}catch (FileNotFoundException errorMessage) {
			errorMessage.printStackTrace();
				throw new CreditException("Input File not found", errorMessage);
			}
		catch(IOException errorMessage) {
			errorMessage.printStackTrace();
			throw new CreditException("Input Output exception");
			
		}
		
			
		
		
		return dataList;
	}
}



