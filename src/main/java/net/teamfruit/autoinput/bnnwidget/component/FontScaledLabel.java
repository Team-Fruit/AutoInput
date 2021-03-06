package net.teamfruit.autoinput.bnnwidget.component;

import java.awt.Color;

import javax.annotation.Nonnull;

import org.apache.commons.lang3.StringUtils;

import net.teamfruit.autoinput.bnnwidget.WEvent;
import net.teamfruit.autoinput.bnnwidget.font.WFontRenderer;
import net.teamfruit.autoinput.bnnwidget.position.Area;
import net.teamfruit.autoinput.bnnwidget.position.Point;
import net.teamfruit.autoinput.bnnwidget.position.R;
import net.teamfruit.autoinput.bnnwidget.render.OpenGL;

public class FontScaledLabel extends MLabel {
	protected final @Nonnull WFontRenderer wf;

	public FontScaledLabel(final @Nonnull R position, final @Nonnull WFontRenderer wf) {
		super(position);
		this.wf = wf;
	}

	@Override
	protected void drawText(final @Nonnull WEvent ev, final @Nonnull Area a, final @Nonnull Point p, final float frame, final float opacity) {
		final Color c = new Color(getColor());
		OpenGL.glColor4i(c.getRed(), c.getGreen(), c.getBlue(), (int) (opacity*c.getAlpha()));
		this.wf.drawString(getText(), a, ev.owner.guiScale(), getAlign(), getVerticalAlign(), isShadow());
		final String watermark = getWatermark();
		if (watermark!=null&&!StringUtils.isEmpty(watermark)&&StringUtils.isEmpty(getText())) {
			final Color w = new Color(getWatermarkColor());
			OpenGL.glColor4i(w.getRed(), w.getGreen(), w.getBlue(), (int) (opacity*c.getAlpha()));
			this.wf.drawString(getText(), a, ev.owner.guiScale(), getAlign(), getVerticalAlign(), isShadow());
		}
	}
}
