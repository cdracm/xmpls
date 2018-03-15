package inspection;

import com.intellij.codeInsight.AnnotationUtil;
import com.intellij.codeInspection.LocalInspectionTool;
import com.intellij.codeInspection.LocalInspectionToolSession;
import com.intellij.codeInspection.ProblemsHolder;
import com.intellij.psi.*;
import com.intellij.util.ArrayUtil;
import org.jetbrains.annotations.NotNull;

public class PublicSwearInspection extends LocalInspectionTool {
  @NotNull
  @Override
  public PsiElementVisitor buildVisitor(@NotNull ProblemsHolder holder, boolean isOnTheFly, @NotNull LocalInspectionToolSession session) {
    return new JavaElementVisitor() {
      @Override
      public void visitLiteralExpression(PsiLiteralExpression expression) {
        if (isPublicArgument(expression) &&
            expression.toString().contains("Fuc")) {
          holder.registerProblem(expression, "Fuc! You swearing again");
        }
      }
    };
  }

  private boolean isPublicArgument(PsiLiteralExpression expression) {
    PsiElement parent = expression.getParent();
    if (!(parent instanceof PsiExpressionList)) return false;
    PsiElement call = parent.getParent();
    if (!(call instanceof PsiCall)) return false;
    PsiMethod method = ((PsiCall) call).resolveMethod();
    if (method == null) return false;
    PsiExpression[] expressions = ((PsiExpressionList) parent).getExpressions();
    int argIndex = ArrayUtil.indexOf(expressions, expression);
    PsiParameter[] parameters = method.getParameterList().getParameters();
    if (parameters.length <= argIndex) return false;
    PsiParameter parameter = parameters[argIndex];
    return AnnotationUtil.isAnnotated(parameter, anno, true);
  }
  private static final String anno = "org.jetbrains.annotations.Nls";

  @Override
  public String getID() {
    return "PublicSwearing";
  }
}
