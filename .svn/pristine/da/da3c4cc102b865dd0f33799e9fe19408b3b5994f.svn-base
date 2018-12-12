package com.common.controller;

import com.biz.dto.gzjl.GzjhDto;
import com.biz.dto.gzjl.GzjlDto;
import com.biz.dto.gzjl.GzjlmxDto;
import com.biz.service.GzjlService;
import com.biz.service.GzjlscService;
import com.biz.service.GzzdService;
import com.common.dto.FileDto;
import com.core.model.checkmis.Gzzd;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.util.ConfigUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@RequestMapping("file")
@Controller
public class FileController {
    @Autowired
    private GzjlService gzjlService;
    @Autowired
    private GzzdService gzzdService;
    private Logger logger = Logger.getLogger(FileController.class);
    private Paragraph getCenterTxt(String text,Font ft){
        if(null==text){
            text="";
        }
        Paragraph paragraph = new Paragraph(text, ft);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        return paragraph;
    }
    @RequestMapping("gzzd")
    public void downloadWord(HttpServletRequest request, HttpServletResponse response,Long id) throws Exception {
        response.reset();
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/msword");
        Gzzd g=this.gzzdService.get(id);
        response.setHeader("Content-Disposition", "attachment; filename=" + encodeName(g.getBt()+".doc", request));
        String file= ConfigUtil.get("file_dir") + "/gzzd/"+g.getId()+".doc";
        InputStream in =new FileInputStream(new File(file));
        OutputStream out=response.getOutputStream();
        int byteRead=0;
        byte[]buffer=new byte[1024];
        while ((byteRead=in.read(buffer))!=-1){
            out.write(buffer,0,byteRead);
        }
        in.close();
        out.close();
        response.flushBuffer();

    }
    @RequestMapping("gzjl")
    public void downloadPdf(HttpServletRequest request, HttpServletResponse response, GzjlmxDto g) {
        try {
            FileDto fileDto = gzjlService.getDownPdfData(g);
            response.reset();
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=" + encodeName(fileDto.getFileName(), request));

            Document document = new Document();
            Font fontChar = new Font();
            fontChar.setSize(7);
            fontChar.setColor(BaseColor.DARK_GRAY);
            BaseFont bf = BaseFont.createFont("fangsong_GB2312.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font fontChinese = new Font(bf, 10, Font.NORMAL);// 中文字体
            fontChinese.setSize(8);//字体大小
            OutputStream os=response.getOutputStream();
            PdfWriter pdfWriter = PdfWriter.getInstance(document,os);// 文档输出流
            document.open();
            Font ft = new Font(bf, 15, Font.NORMAL);// 中文字体
            // Chapter c=new Chapter(,1).seta;
            Paragraph ttile = new Paragraph(fileDto.getFileName(), ft);
            ttile.setAlignment(Element.ALIGN_CENTER);
            document.add(ttile);

            PdfPTable table = new PdfPTable(new float[]{7, 15, 15, 15, 27, 15, 14, 16, 14, 14});// 8列的表格以及单元格的宽度。
            table.setSpacingBefore(30);
            table.setPaddingTop(2);// 顶部空白区高度
            table.setTotalWidth(360);//表格整体宽度

            PdfPCell xh = new PdfPCell(new Phrase("序号", fontChinese));
            //xh.setColspan(1);//占据八列
            xh.setRowspan(2);
            xh.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(xh);
            PdfPCell rq = new PdfPCell(new Phrase("日期", fontChinese));
            //xh.setColspan(1);//占据八列
            rq.setRowspan(2);
            table.addCell(rq);
            PdfPCell jccz = new PdfPCell(getCenterTxt("检查车站",fontChinese));
            jccz.setColspan(3);//占据八列
            jccz.setRowspan(1);
            table.addCell(jccz);
            PdfPCell jclc = new PdfPCell(getCenterTxt("检查列车", fontChinese));
            jclc.setColspan(4);//占据八列
            jclc.setRowspan(1);
            table.addCell(jclc);
            PdfPCell bz = new PdfPCell(new Phrase("备注", fontChinese));
            //xh.setColspan(1);//占据八列
            bz.setRowspan(2);
            table.addCell(bz);
            table.addCell(new Paragraph("车站", fontChinese));
            table.addCell(new Paragraph("时间", fontChinese));
            table.addCell(new Paragraph("检查重点", fontChinese));
            table.addCell(new Paragraph("车次", fontChinese));
            table.addCell(new Paragraph("担当段", fontChinese));
            table.addCell(new Paragraph("区段", fontChinese));
            table.addCell(new Paragraph("检查时间", fontChinese));
            int i=0;
            for(GzjhDto jh:fileDto.getJhList()){
                i++;
                table.addCell(getCenterTxt(i+"",fontChar));
                table.addCell(getCenterTxt(jh.getRq(),fontChar));
                if(!"0".equals(jh.getType())){//休息其他
                    String text="其他";
                    if("1".equals(jh.getType())){
                        text="休息";
                    }

                    PdfPCell hb = new PdfPCell(getCenterTxt(text, fontChinese));
                    hb.setColspan(7);
                    table.addCell(hb);
                }else{
                    table.addCell(getCenterTxt(jh.getCz(),fontChar));
                    table.addCell(getCenterTxt(jh.getSj(),fontChar));
                    table.addCell(getCenterTxt(jh.getJczd(),fontChar));
                    table.addCell(getCenterTxt(jh.getCc(),fontChar));
                    table.addCell(getCenterTxt(jh.getDdd(),fontChar));
                    table.addCell(getCenterTxt(jh.getQd(),fontChar));
                    table.addCell(getCenterTxt(jh.getJcsj(),fontChar));
                }
                table.addCell(getCenterTxt(jh.getBz(),fontChar));
            }
            document.add(table);
            document.close();
            pdfWriter.flush();
            os.flush();
            os.close();
            response.flushBuffer();
        } catch (Exception e) {
            logger.error("download fail", e);
        }
    }

    private String encodeName(String fileName, HttpServletRequest request) throws UnsupportedEncodingException {
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        String agent = (String) request.getHeader("USER-AGENT"); //判断浏览器类型
        if (agent != null && agent.indexOf("Fireforx") != -1) {
            fileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");   //UTF-8编码，防止输出文件名乱码
        } else {
            fileName = URLEncoder.encode(fileName, "UTF-8");
        }
        return fileName;
    }
}
