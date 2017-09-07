package net.masterthought.dlanguage.stubs.types;

import com.intellij.lang.ASTNode;
import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.stubs.StubInputStream;
import com.intellij.psi.stubs.StubOutputStream;
import net.masterthought.dlanguage.psi.DLanguageEnumDeclaration;
import net.masterthought.dlanguage.psi.impl.named.DLanguageEnumDeclarationImpl;
import net.masterthought.dlanguage.stubs.DLanguageEnumDeclarationStub;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * Created by francis on 3/9/2017.
 */
public class EnumDeclarationStubElementType extends DNamedStubElementType<DLanguageEnumDeclarationStub, DLanguageEnumDeclaration> {
    public EnumDeclarationStubElementType(final String debugName) {
        super(debugName);
    }

    @Override
    public DLanguageEnumDeclaration createPsi(@NotNull final DLanguageEnumDeclarationStub stub) {
        return new DLanguageEnumDeclarationImpl(stub, this);
    }

    @Override
    public boolean shouldCreateStub(final ASTNode node) {
        return true;
    }

    @Override
    public DLanguageEnumDeclarationStub createStub(@NotNull final DLanguageEnumDeclaration psi, final StubElement parentStub) {
        return new DLanguageEnumDeclarationStub(parentStub, this, psi.getName());
    }

    @Override
    public void serialize(@NotNull final DLanguageEnumDeclarationStub stub, @NotNull final StubOutputStream dataStream) throws IOException {
        dataStream.writeName(stub.getName());
    }

    @NotNull
    @Override
    public DLanguageEnumDeclarationStub deserialize(@NotNull final StubInputStream dataStream, final StubElement parentStub) throws IOException {
        return new DLanguageEnumDeclarationStub(parentStub, this, dataStream.readName());
    }
}
