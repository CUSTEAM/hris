package action.print;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.formula.functions.Now;

public class BirthPrint {
	
	HttpServletResponse response;
	List<Map>list;
	
	public BirthPrint(HttpServletResponse response, List<Map>list){
		this.response=response;
		this.list=list;
	}
	
	
	
	
	public void print() throws IOException, ParseException{
		
		Date date=new Date();
		response.setContentType("text/html; charset=UTF-8");
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-disposition","attachment;filename="+date.getTime()+".xls");			
		
		PrintWriter out=response.getWriter();
		
		out.println ("<?xml version='1.0'?>");
		out.println ("<?mso-application progid='Excel.Sheet'?>");
		out.println ("<Workbook xmlns='urn:schemas-microsoft-com:office:spreadsheet'");
		out.println (" xmlns:o='urn:schemas-microsoft-com:office:office'");
		out.println (" xmlns:x='urn:schemas-microsoft-com:office:excel'");
		out.println (" xmlns:ss='urn:schemas-microsoft-com:office:spreadsheet'");
		out.println (" xmlns:html='http://www.w3.org/TR/REC-html40'>");
		out.println (" <DocumentProperties xmlns='urn:schemas-microsoft-com:office:office'>");
		out.println ("  <Author>shawn</Author>");
		out.println ("  <LastAuthor>shawn</LastAuthor>");
		out.println ("  <Created>2015-01-07T04:40:51Z</Created>");
		out.println ("  <Version>15.00</Version>");
		out.println (" </DocumentProperties>");
		out.println (" <OfficeDocumentSettings xmlns='urn:schemas-microsoft-com:office:office'>");
		out.println ("  <AllowPNG/>");
		out.println (" </OfficeDocumentSettings>");
		out.println (" <ExcelWorkbook xmlns='urn:schemas-microsoft-com:office:excel'>");
		out.println ("  <WindowHeight>8055</WindowHeight>");
		out.println ("  <WindowWidth>10425</WindowWidth>");
		out.println ("  <WindowTopX>0</WindowTopX>");
		out.println ("  <WindowTopY>0</WindowTopY>");
		out.println ("  <ProtectStructure>False</ProtectStructure>");
		out.println ("  <ProtectWindows>False</ProtectWindows>");
		out.println (" </ExcelWorkbook>");
		out.println (" <Styles>");
		out.println ("  <Style ss:ID='Default' ss:Name='Normal'>");
		out.println ("   <Alignment ss:Vertical='Center'/>");
		out.println ("   <Borders/>");
		out.println ("   <Font ss:FontName='微軟正黑體' x:CharSet='136' x:Family='Swiss' ss:Size='12'");
		out.println ("    ss:Color='#000000'/>");
		out.println ("   <Interior/>");
		out.println ("   <NumberFormat/>");
		out.println ("   <Protection/>");
		out.println ("  </Style>");
		out.println ("  <Style ss:ID='s65' ss:Name='超連結'>");
		out.println ("   <Font ss:FontName='微軟正黑體' x:CharSet='136' x:Family='Swiss' ss:Size='12'");
		out.println ("    ss:Color='#0563C1' ss:Underline='Single'/>");
		out.println ("  </Style>");
		out.println ("  <Style ss:ID='s91'>");
		out.println ("   <Alignment ss:Horizontal='Center' ss:Vertical='Center'/>");
		out.println ("   <Borders>");
		out.println ("    <Border ss:Position='Bottom' ss:LineStyle='Continuous' ss:Weight='1'");
		out.println ("     ss:Color='#000000'/>");
		out.println ("    <Border ss:Position='Left' ss:LineStyle='Continuous' ss:Weight='1'");
		out.println ("     ss:Color='#000000'/>");
		out.println ("    <Border ss:Position='Right' ss:LineStyle='Continuous' ss:Weight='1'");
		out.println ("     ss:Color='#000000'/>");
		out.println ("    <Border ss:Position='Top' ss:LineStyle='Continuous' ss:Weight='1'");
		out.println ("     ss:Color='#000000'/>");
		out.println ("   </Borders>");
		out.println ("   <Font ss:FontName='微軟正黑體' x:CharSet='136' x:Family='Swiss' ss:Size='12'/>");
		out.println ("   <NumberFormat ss:Format='@'/>");
		out.println ("  </Style>");
		out.println ("  <Style ss:ID='s92'>");
		out.println ("   <Borders>");
		out.println ("    <Border ss:Position='Bottom' ss:LineStyle='Continuous' ss:Weight='1'");
		out.println ("     ss:Color='#000000'/>");
		out.println ("    <Border ss:Position='Left' ss:LineStyle='Continuous' ss:Weight='1'");
		out.println ("     ss:Color='#000000'/>");
		out.println ("    <Border ss:Position='Right' ss:LineStyle='Continuous' ss:Weight='1'");
		out.println ("     ss:Color='#000000'/>");
		out.println ("    <Border ss:Position='Top' ss:LineStyle='Continuous' ss:Weight='1'");
		out.println ("     ss:Color='#000000'/>");
		out.println ("   </Borders>");
		out.println ("   <Font ss:FontName='微軟正黑體' x:CharSet='136' x:Family='Swiss' ss:Size='12'");
		out.println ("    ss:Color='#000000'/>");
		out.println ("   <NumberFormat ss:Format='@'/>");
		out.println ("  </Style>");
		out.println ("  <Style ss:ID='s93'>");
		out.println ("   <Font ss:FontName='微軟正黑體' x:CharSet='136' x:Family='Swiss' ss:Size='12'");
		out.println ("    ss:Color='#000000'/>");
		out.println ("   <NumberFormat ss:Format='@'/>");
		out.println ("  </Style>");
		out.println ("  <Style ss:ID='s94' ss:Parent='s65'>");
		out.println ("   <Borders>");
		out.println ("    <Border ss:Position='Bottom' ss:LineStyle='Continuous' ss:Weight='1'");
		out.println ("     ss:Color='#000000'/>");
		out.println ("    <Border ss:Position='Left' ss:LineStyle='Continuous' ss:Weight='1'");
		out.println ("     ss:Color='#000000'/>");
		out.println ("    <Border ss:Position='Right' ss:LineStyle='Continuous' ss:Weight='1'");
		out.println ("     ss:Color='#000000'/>");
		out.println ("    <Border ss:Position='Top' ss:LineStyle='Continuous' ss:Weight='1'");
		out.println ("     ss:Color='#000000'/>");
		out.println ("   </Borders>");
		out.println ("   <Font ss:FontName='微軟正黑體' x:CharSet='136' x:Family='Swiss' ss:Size='12'");
		out.println ("    ss:Color='#0563C1' ss:Underline='Single'/>");
		out.println ("   <NumberFormat ss:Format='@'/>");
		out.println ("  </Style>");
		out.println (" </Styles>");
		
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat s1=new SimpleDateFormat("M月 d日");
		Calendar c=Calendar.getInstance();
		int m=c.get(Calendar.MONTH);
		List<Map>empls;
		
		for(int i=0; i<12; i++){
			
			empls=new ArrayList();
			for(int j=0; j<list.size(); j++){
				
				c.setTime(sf.parse(String.valueOf(list.get(j).get("bdate"))));
				
				if(c.get(Calendar.MONTH)==i){
					empls.add(list.get(j));
				}				
			}		
			out.println (" <Worksheet ss:Name='"+(i+1)+"月'>");
			out.println ("  <Table ss:ExpandedColumnCount='5' ss:ExpandedRowCount='"+(empls.size()+1)+"' x:FullColumns='1'");
			out.println ("   x:FullRows='1' ss:StyleID='s93' ss:DefaultColumnWidth='54'");
			out.println ("   ss:DefaultRowHeight='16.5'>");
			out.println ("   <Column ss:StyleID='s92' ss:AutoFitWidth='0' ss:Width='108'/>");
			out.println ("   <Column ss:StyleID='s92' ss:AutoFitWidth='0' ss:Width='163.5'/>");
			out.println ("   <Column ss:StyleID='s92' ss:AutoFitWidth='0' ss:Width='135'/>");
			out.println ("   <Column ss:StyleID='s92' ss:AutoFitWidth='0' ss:Width='99.75'/>");
			out.println ("   <Column ss:StyleID='s92' ss:AutoFitWidth='0' ss:Width='267.75'/>");
			out.println ("   <Row ss:AutoFitHeight='0' ss:Height='17.25'>");
			out.println ("    <Cell ss:StyleID='s91'><Data ss:Type='String'>姓名</Data></Cell>");
			out.println ("    <Cell ss:StyleID='s91'><Data ss:Type='String'>單位</Data></Cell>");
			out.println ("    <Cell ss:StyleID='s91'><Data ss:Type='String'>職稱</Data></Cell>");
			out.println ("    <Cell ss:StyleID='s91'><Data ss:Type='String'>出生月日</Data></Cell>");
			out.println ("    <Cell><Data ss:Type='String'>電子郵件</Data></Cell>");
			out.println ("   </Row>");
			
			for(int j=0; j<empls.size(); j++){
				
				out.println ("   <Row ss:AutoFitHeight='0'>");
				out.println ("    <Cell><Data ss:Type='String'>"+empls.get(j).get("cname")+"</Data></Cell>");
				if(empls.get(j).get("dname")!=null && empls.get(j).get("uname")!=null){
					out.println ("    <Cell><Data ss:Type='String'>"+empls.get(j).get("dname")+"/"+empls.get(j).get("uname")+"</Data></Cell>");
				}else{					
					if(empls.get(j).get("dname")==null){
						out.println ("    <Cell><Data ss:Type='String'>"+empls.get(j).get("uname")+"</Data></Cell>");
					}else{
						out.println ("    <Cell><Data ss:Type='String'>"+empls.get(j).get("dname")+"</Data></Cell>");
					}
				}
				out.println ("    <Cell><Data ss:Type='String'>"+empls.get(j).get("sname")+"</Data></Cell>");
				
				out.println ("    <Cell><Data ss:Type='String'>"+s1.format(sf.parse(String.valueOf(empls.get(j).get("bdate"))))+"</Data></Cell>");
				out.println ("    <Cell ss:StyleID='s94' ss:HRef='mailto:"+empls.get(j).get("Email")+"'><Data ss:Type='String'>"+empls.get(j).get("Email")+"</Data></Cell>");
				out.println ("   </Row>");
				
			}
			
			out.println ("  </Table>");
			out.println ("  <WorksheetOptions xmlns='urn:schemas-microsoft-com:office:excel'>");
			out.println ("   <PageSetup>");
			out.println ("    <Layout x:Orientation='Landscape'/>");
			out.println ("    <Header x:Margin='0.3' x:Data='&amp;C&amp;&quot;微軟正黑體,粗體&quot;&amp;18 "+(i+1)+"月份教職員工慶生名單'/>");
			out.println ("    <Footer x:Margin='0.3' x:Data='&amp;L&amp;D &amp;T&amp;R&amp;P/&amp;N'/>");
			out.println ("    <PageMargins x:Bottom='0.75' x:Left='0.25' x:Right='0.25' x:Top='0.75'/>");
			out.println ("   </PageSetup>");
			out.println ("   <Unsynced/>");
			out.println ("   <Print>");
			out.println ("    <ValidPrinterInfo/>");
			out.println ("    <PaperSizeIndex>9</PaperSizeIndex>");
			out.println ("    <HorizontalResolution>-1</HorizontalResolution>");
			out.println ("    <VerticalResolution>-1</VerticalResolution>");
			out.println ("   </Print>");
			out.println ("   <Selected/>");
			out.println ("   <Panes>");
			out.println ("    <Pane>");
			out.println ("     <Number>3</Number>");
			out.println ("     <ActiveRow>20</ActiveRow>");
			out.println ("     <ActiveCol>4</ActiveCol>");
			out.println ("    </Pane>");
			out.println ("   </Panes>");
			out.println ("   <ProtectObjects>False</ProtectObjects>");
			out.println ("   <ProtectScenarios>False</ProtectScenarios>");
			out.println ("  </WorksheetOptions>");
			out.println (" </Worksheet>");
		
		
		
		}
		
		
		out.println ("</Workbook>");
		
		out.close();
	}
}
