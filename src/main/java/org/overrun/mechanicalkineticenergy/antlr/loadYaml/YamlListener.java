package org.overrun.mechanicalkineticenergy.antlr.loadYaml;// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link YamlParser}.
 */
public interface YamlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link YamlParser#yaml}.
	 * @param ctx the parse tree
	 */
	void enterYaml(YamlParser.YamlContext ctx);
	/**
	 * Exit a parse tree produced by {@link YamlParser#yaml}.
	 * @param ctx the parse tree
	 */
	void exitYaml(YamlParser.YamlContext ctx);
	/**
	 * Enter a parse tree produced by {@link YamlParser#y}.
	 * @param ctx the parse tree
	 */
	void enterY(YamlParser.YContext ctx);
	/**
	 * Exit a parse tree produced by {@link YamlParser#y}.
	 * @param ctx the parse tree
	 */
	void exitY(YamlParser.YContext ctx);
	/**
	 * Enter a parse tree produced by {@link YamlParser#code}.
	 * @param ctx the parse tree
	 */
	void enterCode(YamlParser.CodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link YamlParser#code}.
	 * @param ctx the parse tree
	 */
	void exitCode(YamlParser.CodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link YamlParser#listCode}.
	 * @param ctx the parse tree
	 */
	void enterListCode(YamlParser.ListCodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link YamlParser#listCode}.
	 * @param ctx the parse tree
	 */
	void exitListCode(YamlParser.ListCodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link YamlParser#codeT}.
	 * @param ctx the parse tree
	 */
	void enterCodeT(YamlParser.CodeTContext ctx);
	/**
	 * Exit a parse tree produced by {@link YamlParser#codeT}.
	 * @param ctx the parse tree
	 */
	void exitCodeT(YamlParser.CodeTContext ctx);
	/**
	 * Enter a parse tree produced by {@link YamlParser#tabCode}.
	 * @param ctx the parse tree
	 */
	void enterTabCode(YamlParser.TabCodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link YamlParser#tabCode}.
	 * @param ctx the parse tree
	 */
	void exitTabCode(YamlParser.TabCodeContext ctx);
}