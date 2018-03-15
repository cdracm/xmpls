package javac;

import com.sun.source.tree.CompilationUnitTree;
import com.sun.source.tree.MethodTree;
import com.sun.source.util.*;

import javax.tools.Diagnostic;

public class SwearJavacPlugin implements Plugin {
  @Override
  public void init(JavacTask task, String... args) {
    task.addTaskListener(new TaskListener() {
      @Override
      public void started(TaskEvent e) {
        if (e.getKind() == TaskEvent.Kind.GENERATE) {
          CompilationUnitTree tree = e.getCompilationUnit();
          tree.accept(new TreeScanner<Void, Void>() {
            @Override
            public Void visitMethod(MethodTree methodNode,
                                    Void aVoid) {
              if (methodNode.getName().toString().contains("Fuc")) {
                Trees trees = Trees.instance(task);
                trees.printMessage(Diagnostic.Kind.ERROR,
                    "No swearing!", methodNode, tree);
              }
              return super.visitMethod(methodNode, aVoid);
            }
          }, null);
        }
      }

      @Override
      public void finished(TaskEvent e) {
      }
    });
  }

  @Override
  public String getName() {
    return "NoSwearingPlugin";
  }
}
