package io.github.intellij.dlanguage.psi;

import com.intellij.psi.PsiElement;
import java.util.List;
import org.jetbrains.annotations.NotNull;


public interface DLanguageTemplateParameterList extends PsiElement {

    @NotNull
    public List<DLanguageTemplateParameter> getTemplateParameters();

    @NotNull
    public List<PsiElement> getOP_COMMAs();

}
