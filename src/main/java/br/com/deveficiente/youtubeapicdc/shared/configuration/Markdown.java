package br.com.deveficiente.youtubeapicdc.shared.configuration;

import java.util.Arrays;
import java.util.List;

import org.commonmark.Extension;
import org.commonmark.ext.autolink.AutolinkExtension;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

/**
 * Facilitador de gerador de markdown
 * @author alberto
 *
 */
public class Markdown {
	
	private static List<Extension> extensions = Arrays.asList(AutolinkExtension.create());
	private static Parser parser = Parser.builder().extensions(extensions).build();
	private static HtmlRenderer renderer = HtmlRenderer.builder().build();
	
	/**
	 * 
	 * @param text texto em markdown. 
	 * @return
	 */
	public static String renderHtml(String text) {
		Node document = parser.parse(text);
		return renderer.render(document);
	}
	
	//vou deixar esse main aqui pq eu(alberto) sinto que vou querer rodar ele de novo outras vezes...
	public static void main(String[] args) {
		String text = "**Being a parent today is much easier than it was a century ago**. [For](http://www.uol.com.br) one, our society is free from many of the diseases that, not that long ago, killed or disabled many infants. Then there are the parenting aids, from designer buggies to baby monitors, which make parenting that much easier. And of course, there are babysitters and daycare centers that afford parents more freedom to carry on with “normal” life.\n" + 
				"\n" + 
				"And yet, despite these amenities, modern parenthood is not a bed of roses. Raising a child today can lead to increased stress, lack of sleep and loss of autonomy. Of course, none of this takes away from the joy of raising a child. But no parent should underestimate the hardships involved – hardships that these blinks will explore.\n" + 
				"\n" + 
				"In these blinks you’ll discover\n" + 
				"\n" + 
				"why being able to work from home might add to your level of stress;\n" + 
				"what is going through the minds of soccer moms; and\n" + 
				"why you should give your teenager a little bit of freedom, but not too much.";
		System.out.println(Markdown.renderHtml(text));
	}
}
