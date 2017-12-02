package io.github.intellij.dlanguage.psi.impl;

import static io.github.intellij.dlanguage.psi.DlangTypes.OP_BRACES_LEFT;
import static io.github.intellij.dlanguage.psi.DlangTypes.OP_BRACES_RIGHT;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.psi.util.PsiTreeUtil;
import io.github.intellij.dlanguage.psi.DLanguageAliasDeclaration;
import io.github.intellij.dlanguage.psi.DLanguageAliasThisDeclaration;
import io.github.intellij.dlanguage.psi.DLanguageAnonymousEnumDeclaration;
import io.github.intellij.dlanguage.psi.DLanguageAttribute;
import io.github.intellij.dlanguage.psi.DLanguageAttributeDeclaration;
import io.github.intellij.dlanguage.psi.DLanguageClassDeclaration;
import io.github.intellij.dlanguage.psi.DLanguageConditionalDeclaration;
import io.github.intellij.dlanguage.psi.DLanguageConstructor;
import io.github.intellij.dlanguage.psi.DLanguageDebugSpecification;
import io.github.intellij.dlanguage.psi.DLanguageDeclaration;
import io.github.intellij.dlanguage.psi.DLanguageDestructor;
import io.github.intellij.dlanguage.psi.DLanguageEponymousTemplateDeclaration;
import io.github.intellij.dlanguage.psi.DLanguageFunctionDeclaration;
import io.github.intellij.dlanguage.psi.DLanguageImportDeclaration;
import io.github.intellij.dlanguage.psi.DLanguageInterfaceDeclaration;
import io.github.intellij.dlanguage.psi.DLanguageInvariant;
import io.github.intellij.dlanguage.psi.DLanguageMixinDeclaration;
import io.github.intellij.dlanguage.psi.DLanguageMixinTemplateDeclaration;
import io.github.intellij.dlanguage.psi.DLanguagePragmaDeclaration;
import io.github.intellij.dlanguage.psi.DLanguageSharedStaticConstructor;
import io.github.intellij.dlanguage.psi.DLanguageSharedStaticDestructor;
import io.github.intellij.dlanguage.psi.DLanguageStaticAssertDeclaration;
import io.github.intellij.dlanguage.psi.DLanguageStaticConstructor;
import io.github.intellij.dlanguage.psi.DLanguageStaticDestructor;
import io.github.intellij.dlanguage.psi.DLanguageUnittest;
import io.github.intellij.dlanguage.psi.DLanguageVariableDeclaration;
import io.github.intellij.dlanguage.psi.DLanguageVersionSpecification;
import io.github.intellij.dlanguage.psi.DlangVisitor;
import io.github.intellij.dlanguage.resolve.ScopeProcessorImpl;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class DLanguageDeclarationImpl extends ASTWrapperPsiElement implements DLanguageDeclaration {

    public DLanguageDeclarationImpl(ASTNode node) {
        super(node);
    }

    public void accept(@NotNull DlangVisitor visitor) {
        visitor.visitDeclaration(this);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof DlangVisitor) {
            accept((DlangVisitor) visitor);
        } else {
            super.accept(visitor);
        }
    }

    @Nullable
    public DLanguageAliasThisDeclaration getAliasThisDeclaration() {
        return PsiTreeUtil.getChildOfType(this, DLanguageAliasThisDeclaration.class);
    }

    @Nullable
    public DLanguageAliasDeclaration getAliasDeclaration() {
        return PsiTreeUtil.getChildOfType(this, DLanguageAliasDeclaration.class);
    }

    @Nullable
    public DLanguageClassDeclaration getClassDeclaration() {
        return PsiTreeUtil.getChildOfType(this, DLanguageClassDeclaration.class);
    }

    @Nullable
    public DLanguageConditionalDeclaration getConditionalDeclaration() {
        return PsiTreeUtil.getChildOfType(this, DLanguageConditionalDeclaration.class);
    }

    @Nullable
    public DLanguageConstructor getConstructor() {
        return PsiTreeUtil.getChildOfType(this, DLanguageConstructor.class);
    }

    @Nullable
    public DLanguageDestructor getDestructor() {
        return PsiTreeUtil.getChildOfType(this, DLanguageDestructor.class);
    }

    @Nullable
    public DLanguageAnonymousEnumDeclaration getAnonymousEnumDeclaration() {
        return PsiTreeUtil.getChildOfType(this, DLanguageAnonymousEnumDeclaration.class);
    }

    @Nullable
    public DLanguageEponymousTemplateDeclaration getEponymousTemplateDeclaration() {
        return PsiTreeUtil.getChildOfType(this, DLanguageEponymousTemplateDeclaration.class);
    }

    @Nullable
    public DLanguageEnumDeclaration getEnumDeclaration() {
        return PsiTreeUtil.getChildOfType(this, DLanguageEnumDeclaration.class);
    }

    @Nullable
    public DLanguageImportDeclaration getImportDeclaration() {
        return PsiTreeUtil.getChildOfType(this, DLanguageImportDeclaration.class);
    }

    @Nullable
    public DLanguageInterfaceDeclaration getInterfaceDeclaration() {
        return PsiTreeUtil.getChildOfType(this, DLanguageInterfaceDeclaration.class);
    }

    @Nullable
    public DLanguageMixinTemplateDeclaration getMixinTemplateDeclaration() {
        return PsiTreeUtil.getChildOfType(this, DLanguageMixinTemplateDeclaration.class);
    }

    @Nullable
    public DLanguageMixinDeclaration getMixinDeclaration() {
        return PsiTreeUtil.getChildOfType(this, DLanguageMixinDeclaration.class);
    }

    @Nullable
    public DLanguagePragmaDeclaration getPragmaDeclaration() {
        return PsiTreeUtil.getChildOfType(this, DLanguagePragmaDeclaration.class);
    }

    @Nullable
    public DLanguageSharedStaticConstructor getSharedStaticConstructor() {
        return PsiTreeUtil.getChildOfType(this, DLanguageSharedStaticConstructor.class);
    }

    @Nullable
    public DLanguageSharedStaticDestructor getSharedStaticDestructor() {
        return PsiTreeUtil.getChildOfType(this, DLanguageSharedStaticDestructor.class);
    }

    @Nullable
    public DLanguageStaticConstructor getStaticConstructor() {
        return PsiTreeUtil.getChildOfType(this, DLanguageStaticConstructor.class);
    }

    @Nullable
    public DLanguageStaticDestructor getStaticDestructor() {
        return PsiTreeUtil.getChildOfType(this, DLanguageStaticDestructor.class);
    }

    @Nullable
    public DLanguageStaticAssertDeclaration getStaticAssertDeclaration() {
        return PsiTreeUtil.getChildOfType(this, DLanguageStaticAssertDeclaration.class);
    }

    @Nullable
    public DLanguageStructDeclaration getStructDeclaration() {
        return PsiTreeUtil.getChildOfType(this, DLanguageStructDeclaration.class);
    }

    @Nullable
    public DLanguageTemplateDeclaration getTemplateDeclaration() {
        return PsiTreeUtil.getChildOfType(this, DLanguageTemplateDeclaration.class);
    }

    @Nullable
    public DLanguageUnionDeclaration getUnionDeclaration() {
        return PsiTreeUtil.getChildOfType(this, DLanguageUnionDeclaration.class);
    }

    @Nullable
    public DLanguageInvariant getInvariant() {
        return PsiTreeUtil.getChildOfType(this, DLanguageInvariant.class);
    }

    @Nullable
    public DLanguageUnittest getUnittest() {
        return PsiTreeUtil.getChildOfType(this, DLanguageUnittest.class);
    }

    @Nullable
    public DLanguageVersionSpecification getVersionSpecification() {
        return PsiTreeUtil.getChildOfType(this, DLanguageVersionSpecification.class);
    }

    @Nullable
    public DLanguageDebugSpecification getDebugSpecification() {
        return PsiTreeUtil.getChildOfType(this, DLanguageDebugSpecification.class);
    }

    @NotNull
    public List<DLanguageAttribute> getAttributes() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, DLanguageAttribute.class);
    }

    @NotNull
    public List<DLanguageDeclaration> getDeclarations() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, DLanguageDeclaration.class);
    }

    @Nullable
    public PsiElement getOP_BRACES_RIGHT() {
        return findChildByType(OP_BRACES_RIGHT);
    }

    @Nullable
    public PsiElement getOP_BRACES_LEFT() {
        return findChildByType(OP_BRACES_LEFT);
    }

    @Nullable
    public DLanguageFunctionDeclaration getFunctionDeclaration() {
        return PsiTreeUtil.getChildOfType(this, DLanguageFunctionDeclaration.class);
    }

    @Nullable
    public DLanguageVariableDeclaration getVariableDeclaration() {
        return PsiTreeUtil.getChildOfType(this, DLanguageVariableDeclaration.class);
    }

    @Nullable
    public DLanguageAttributeDeclaration getAttributeDeclaration() {
        return PsiTreeUtil.getChildOfType(this, DLanguageAttributeDeclaration.class);
    }

    @Override
    public boolean processDeclarations(@NotNull PsiScopeProcessor processor,
        @NotNull ResolveState state,
        PsiElement lastParent,
        @NotNull PsiElement place) {
        return ScopeProcessorImpl.INSTANCE
            .processDeclarations(this, processor, state, lastParent, place);
    }
}
