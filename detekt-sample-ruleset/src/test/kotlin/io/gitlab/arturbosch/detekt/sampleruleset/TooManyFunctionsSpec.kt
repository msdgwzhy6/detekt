package io.gitlab.arturbosch.detekt.sampleruleset

import io.gitlab.arturbosch.detekt.api.Rule
import io.gitlab.arturbosch.detekt.test.RuleTest
import io.gitlab.arturbosch.detekt.test.lint
import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.subject.SubjectSpek
import org.junit.jupiter.api.Test

/**
 * @author Artur Bosch
 */
class TooManyFunctionsSpec : SubjectSpek<TooManyFunctions>({

	subject { TooManyFunctions() }

	describe("a simple test") {

		it("should find one file with too many functions") {
			val findings = subject.lint(code)
			assertThat(findings).hasSize(1)
		}
	}

})

class TooManyFunctionsTest : RuleTest {

	override val rule: Rule = TooManyFunctions()

	@Test fun findOneFile() {
		val findings = rule.lint(code)
		assertThat(findings).hasSize(1)
	}
}

val code: String =
		"""
			class TooManyFunctions : Rule("TooManyFunctions") {

				override fun visitUserType(type: KtUserType) {
					super.visitUserType(type)
				}

				override fun visitReferenceExpression(expression: KtReferenceExpression) {
					super.visitReferenceExpression(expression)
				}

				override fun visitCallExpression(expression: KtCallExpression) {
					super.visitCallExpression(expression)
				}

				override fun visitBlockStringTemplateEntry(entry: KtBlockStringTemplateEntry) {
					super.visitBlockStringTemplateEntry(entry)
				}

				override fun visitUnaryExpression(expression: KtUnaryExpression) {
					super.visitUnaryExpression(expression)
				}

				override fun visitDynamicType(type: KtDynamicType) {
					super.visitDynamicType(type)
				}

				override fun visitDynamicType(type: KtDynamicType, data: Void?): Void {
					return super.visitDynamicType(type, data)
				}

				override fun visitSuperTypeCallEntry(call: KtSuperTypeCallEntry) {
					super.visitSuperTypeCallEntry(call)
				}

				override fun visitParenthesizedExpression(expression: KtParenthesizedExpression) {
					super.visitParenthesizedExpression(expression)
				}

				override fun visitFinallySection(finallySection: KtFinallySection) {
					super.visitFinallySection(finallySection)
				}

				override fun visitStringTemplateExpression(expression: KtStringTemplateExpression) {
					super.visitStringTemplateExpression(expression)
				}

				override fun visitDeclaration(dcl: KtDeclaration) {
					super.visitDeclaration(dcl)
				}

				override fun visitLabeledExpression(expression: KtLabeledExpression) {
					super.visitLabeledExpression(expression)
				}

				override fun visitEscapeStringTemplateEntry(entry: KtEscapeStringTemplateEntry) {
					super.visitEscapeStringTemplateEntry(entry)
				}

				override fun visitScript(script: KtScript) {
					super.visitScript(script)
				}

				override fun visitTypeConstraintList(list: KtTypeConstraintList) {
					super.visitTypeConstraintList(list)
				}

			}
		"""
