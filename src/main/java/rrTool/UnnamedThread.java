package rrTool;

import acme.util.option.CommandLine;
import rr.annotations.Abbrev;
import rr.error.ErrorMessage;
import rr.event.AccessEvent;
import rr.event.StartEvent;
import rr.meta.StartInfo;
import rr.state.ShadowVar;
import rr.tool.Tool;

@Abbrev("UNT")
public class UnnamedThread
    extends Tool {
  public final ErrorMessage<StartInfo> errors = new ErrorMessage<>("UnnamedThread");
  @Override
  public String toString() {
    return "UnnamedThread";
  }

  public UnnamedThread(String name, Tool next, CommandLine commandLine) {
    super(name, next, commandLine);
  }

  @Override
  public ShadowVar makeShadowVar(AccessEvent fae) {
    return fae.getThread();
  }

  @Override
  public void postStart(StartEvent se) {
    String justCreatedThreadName = se.getNewThread().getThread().getName();
    if (  justCreatedThreadName.startsWith("Х")
       || justCreatedThreadName.startsWith("Ж")) {
      errors.error(se.getNewThread(), se.getInfo(),
          "reason:",
          "Unnamed thread was created - bad");
    }
  }
}
