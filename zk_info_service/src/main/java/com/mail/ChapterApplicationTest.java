package com.mail;

import com.ChapterApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author Zhangk
 * @Date 14:32 2019/2/21
 * @Description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ChapterApplication.class)
public class ChapterApplicationTest {

    //@Autowired
    //private JavaMailSender javaMailSender;

    @Test
    public void test() throws Exception{
        /*SimpleMailMessage message = new SimpleMailMessage ();
        message.setFrom("2244697401@qq.com");
        message.setTo("435382864@qq.com");
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");
        javaMailSender.send(message);*/

        /*MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("dyc87112@qq.com");
        helper.setTo("dyc87112@qq.com");
        helper.setSubject("主题：有附件");
        helper.setText("有附件的邮件");
        FileSystemResource file = new FileSystemResource(new File("weixin.jpg"));
        helper.addAttachment("附件-1.jpg", file);
        helper.addAttachment("附件-2.jpg", file);

        javaMailSender.send(mimeMessage);*/

        //addInline函数中资源名称weixin需要与正文中cid:weixin对应起来
        /*MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("dyc87112@qq.com");
        helper.setTo("dyc87112@qq.com");
        helper.setSubject("主题：嵌入静态资源");
        helper.setText("<html><body><img src=\"cid:weixin\" ></body></html>", true);
        FileSystemResource file = new FileSystemResource(new File("weixin.jpg"));
        helper.addInline("weixin", file);

        javaMailSender.send(mimeMessage);*/

        /*MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("dyc87112@qq.com");
        helper.setTo("dyc87112@qq.com");
        helper.setSubject("主题：模板邮件");

        Map<String, Object> model = new HashedMap();
        model.put("username", "didi");
        String text = VelocityEngineUtils.mergeTemplateIntoString(
                velocityEngine, "template.vm", "UTF-8", model);
        helper.setText(text, true);

        StringWriter stringWriter = new StringWriter();
        velocityEngine.mergeTemplate("templateName.vm", "UTF-8", velocityContext, stringWriter);

        javaMailSender.send(mimeMessage);*/
    }
}
