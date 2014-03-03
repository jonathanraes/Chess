package chess.view;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.DateFormat;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.border.Border;
/**
 * Time panel. This will show the current time.
 * A timer to update the time is started when the component
 * is added to its parent and stopped when removed from its parent.
 *
 * @author <A HREF="mailto:colbell@users.sourceforge.net">Colin Bell</A>
 */
public class TimePanel extends JLabel implements ActionListener
{
  /** Timer that updates time. */
  private Timer _timer;

  /** Used to format the displayed date. */
  private DateFormat _fmt = DateFormat.getTimeInstance(DateFormat.LONG);
  private Dimension _prefSize;
  private Calendar _calendar = Calendar.getInstance();
  private long starttime = System.currentTimeMillis();

  /**
   * Default ctor.
   */
  public TimePanel()
  {
    super("", JLabel.CENTER);
  }

  /**
   * Add component to its parent. Start the timer for auto-update.
   */
  public void addNotify()
  {
    super.addNotify();
    _timer = new Timer(1000, this);
    _timer.start();
  }

  /**
   * Remove component from its parent. Stop the timer.
   */
  public void removeNotify()
  {
    super.removeNotify();
    if (_timer != null)
    {
      _timer.stop();
      _timer = null;
    }
  }

  /**
   * Update component with the current time.
   *
   * @param evt   The current event.
   */
  public void actionPerformed(ActionEvent evt)
  {
    _calendar.setTimeInMillis(starttime - System.currentTimeMillis());
    long playtime = ((System.currentTimeMillis() - starttime) / 1000);
    String timeplayed = "";
    if(playtime > 59){
    	timeplayed = (playtime / 60) + "m " + (playtime % 60) + "s";
    } else {
    	timeplayed = playtime + "s";
    }
    setText("Time Played: " + timeplayed);
  }

  public void resetTimer(){
	  starttime = System.currentTimeMillis();
  }
  
  /**
   * Return the preferred size of this component.
   *
   * @return  the preferred size of this component.
   */
  public Dimension getPreferredSize()
  {
   /* if(null == _prefSize)
    {
      // This was originaly done every time.
      // and the count of instantiated objects was amazing
      _prefSize = new Dimension();
      _prefSize.height = 20;
      FontMetrics fm = getFontMetrics(getFont());
      Calendar cal = Calendar.getInstance();
      cal.set(Calendar.HOUR_OF_DAY, 23);
      cal.set(Calendar.MINUTE, 59);
      cal.set(Calendar.SECOND, 59);
      _prefSize.width = fm.stringWidth(_fmt.format(cal.getTime()));
      Border border = getBorder();
      if (border != null)
      {
        Insets ins = border.getBorderInsets(this);
        if (ins != null)
        {
          _prefSize.width += (ins.left + ins.right);
        }
      }
      Insets ins = getInsets();
      if (ins != null)
      {
        _prefSize.width += (ins.left + ins.right) + 20;
      }
    }*/
    return new Dimension(123, 30);
  }
}