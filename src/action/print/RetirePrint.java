package action.print;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

public class RetirePrint {
	HttpServletResponse response;
	List<Map>list;
	public RetirePrint(HttpServletResponse response, List<Map>list){
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
		out.println ("  <LastPrinted>2015-01-07T03:05:34Z</LastPrinted>");
		out.println ("  <Created>2015-01-07T03:00:08Z</Created>");
		out.println ("  <Version>15.00</Version>");
		out.println (" </DocumentProperties>");
		out.println (" <OfficeDocumentSettings xmlns='urn:schemas-microsoft-com:office:office'>");
		out.println ("  <AllowPNG/>");
		out.println (" </OfficeDocumentSettings>");
		out.println (" <ExcelWorkbook xmlns='urn:schemas-microsoft-com:office:excel'>");
		out.println ("  <WindowHeight>11880</WindowHeight>");
		out.println ("  <WindowWidth>28800</WindowWidth>");
		out.println ("  <WindowTopX>0</WindowTopX>");
		out.println ("  <WindowTopY>0</WindowTopY>");
		out.println ("  <ProtectStructure>False</ProtectStructure>");
		out.println ("  <ProtectWindows>False</ProtectWindows>");
		out.println (" </ExcelWorkbook>");
		out.println (" <Styles>");
		out.println ("  <Style ss:ID='Default' ss:Name='Normal'>");
		out.println ("   <Alignment ss:Vertical='Center'/>");
		out.println ("   <Borders/>");
		out.println ("   <Font ss:FontName='新細明體' x:CharSet='136' x:Family='Roman' ss:Size='12'");
		out.println ("    ss:Color='#000000'/>");
		out.println ("   <Interior/>");
		out.println ("   <NumberFormat/>");
		out.println ("   <Protection/>");
		out.println ("  </Style>");
		out.println ("  <Style ss:ID='s67' ss:Name='超連結'>");
		out.println ("   <Font ss:FontName='新細明體' x:CharSet='136' x:Family='Roman' ss:Size='12'");
		out.println ("    ss:Color='#0563C1' ss:Underline='Single'/>");
		out.println ("  </Style>");
		out.println ("  <Style ss:ID='s81'>");
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
		out.println ("   <Font ss:FontName='微軟正黑體' x:CharSet='136' x:Family='Swiss'/>");
		out.println ("   <NumberFormat ss:Format='@'/>");
		out.println ("  </Style>");
		out.println ("  <Style ss:ID='s82'>");
		out.println ("   <Font ss:FontName='微軟正黑體' x:CharSet='136' x:Family='Swiss' ss:Size='12'");
		out.println ("    ss:Color='#000000'/>");
		out.println ("   <NumberFormat ss:Format='@'/>");
		out.println ("  </Style>");
		out.println ("  <Style ss:ID='s83'>");
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
		out.println ("  <Style ss:ID='s84' ss:Parent='s67'>");
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
		
		
		
		out.println (" <Worksheet ss:Name='退撫清單'>");
		out.println ("  <Table ss:ExpandedColumnCount='8' ss:ExpandedRowCount='"+list.size()+1+"' x:FullColumns='1'");
		out.println ("   x:FullRows='1' ss:StyleID='s82' ss:DefaultColumnWidth='54'");
		out.println ("   ss:DefaultRowHeight='15.75'>");
		out.println ("   <Column ss:StyleID='s83' ss:AutoFitWidth='0' ss:Width='72'/>");
		out.println ("   <Column ss:StyleID='s83' ss:AutoFitWidth='0' ss:Width='63.75'/>");
		out.println ("   <Column ss:StyleID='s83' ss:AutoFitWidth='0'/>");
		out.println ("   <Column ss:StyleID='s83' ss:AutoFitWidth='0' ss:Width='48'/>");
		out.println ("   <Column ss:StyleID='s83' ss:AutoFitWidth='0' ss:Width='279'/>");
		out.println ("   <Column ss:StyleID='s83' ss:AutoFitWidth='0' ss:Width='87.75'/>");
		out.println ("   <Column ss:StyleID='s83' ss:AutoFitWidth='0' ss:Width='79.5'/>");
		out.println ("   <Column ss:StyleID='s83' ss:AutoFitWidth='0' ss:Width='166.5'/>");
		out.println ("   <Row>");
		out.println ("    <Cell ss:StyleID='s81'><Data ss:Type='String'>統一證號</Data></Cell>");
		out.println ("    <Cell ss:StyleID='s81'><Data ss:Type='String'>姓名</Data></Cell>");
		out.println ("    <Cell ss:StyleID='s81'><Data ss:Type='String'>出生年月日</Data></Cell>");
		out.println ("    <Cell ss:StyleID='s81'><Data ss:Type='String'>郵遞區號</Data></Cell>");
		out.println ("    <Cell ss:StyleID='s81'><Data ss:Type='String'>地址</Data></Cell>");
		out.println ("    <Cell ss:StyleID='s81'><Data ss:Type='String'>住宅電話</Data></Cell>");
		out.println ("    <Cell ss:StyleID='s81'><Data ss:Type='String'>行動電話</Data></Cell>");
		out.println ("    <Cell ss:StyleID='s81'><Data ss:Type='String'>E-mail</Data></Cell>");
		out.println ("   </Row>");
		
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat s1,s2;
		s1=new SimpleDateFormat("0yyMMdd");
		s2=new SimpleDateFormat("yyyyMMdd");
		Calendar c=Calendar.getInstance();
		String bdate;
		for(int i=0; i<list.size(); i++){
			
			c.setTime(sf.parse(list.get(i).get("bdate").toString()));
			c.add(Calendar.YEAR, -1911);
			if((c.get(Calendar.YEAR))<100){
				bdate=s1.format(c.getTime());
			}else{
				bdate=s2.format(c.getTime());
			}
			
			
			
			out.println ("   <Row>");
			out.println ("    <Cell><Data ss:Type='String'>"+list.get(i).get("idno")+"</Data></Cell>");
			out.println ("    <Cell><Data ss:Type='String'>"+list.get(i).get("cname")+"</Data></Cell>");
			out.println ("    <Cell><Data ss:Type='String'>"+bdate+"</Data></Cell>");
			out.println ("    <Cell><Data ss:Type='String'>"+list.get(i).get("czip")+"</Data></Cell>");
			out.println ("    <Cell><Data ss:Type='String'>"+list.get(i).get("caddr")+"</Data></Cell>");
			out.println ("    <Cell><Data ss:Type='String'>"+list.get(i).get("telephone")+"</Data></Cell>");
			out.println ("    <Cell><Data ss:Type='String'>"+list.get(i).get("CellPhone")+"</Data></Cell>");
			out.println ("    <Cell ss:StyleID='s84' ss:HRef='mailto:"+list.get(i).get("Email")+"'><Data");
			out.println ("      ss:Type='String'>"+list.get(i).get("Email")+"</Data></Cell>");
			out.println ("   </Row>");
		}
		
		out.println ("  </Table>");
		out.println ("  <WorksheetOptions xmlns='urn:schemas-microsoft-com:office:excel'>");
		out.println ("   <PageSetup>");
		out.println ("    <Layout x:Orientation='Landscape'/>");
		out.println ("    <Header x:Margin='0.3' x:Data='&amp;C&amp;&quot;微軟正黑體,標準&quot;中華科技大學教職員退休撫恤離職資遣儲金清單'/>");
		out.println ("    <Footer x:Margin='0.3'/>");
		out.println ("    <PageMargins x:Bottom='0.75' x:Left='0.25' x:Right='0.25' x:Top='0.75'/>");
		out.println ("   </PageSetup>");
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
		out.println ("     <ActiveRow>12</ActiveRow>");
		out.println ("     <ActiveCol>4</ActiveCol>");
		out.println ("    </Pane>");
		out.println ("   </Panes>");
		out.println ("   <ProtectObjects>False</ProtectObjects>");
		out.println ("   <ProtectScenarios>False</ProtectScenarios>");
		out.println ("  </WorksheetOptions>");
		out.println (" </Worksheet>");
		out.println ("</Workbook>");
		
		
		out.close();
		
	}

}
