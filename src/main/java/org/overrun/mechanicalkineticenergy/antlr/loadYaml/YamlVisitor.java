package org.overrun.mechanicalkineticenergy.antlr.loadYaml;// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link YamlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface YamlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link YamlParser#yaml}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYaml(YamlParser.YamlContext ctx);
	/**
	 * Visit a parse tree produced by {@link YamlParser#y}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitY(YamlParser.YContext ctx);
	/**
	 * Visit a parse tree produced by {@link YamlParser#code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCode(YamlParser.CodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link YamlParser#tabCode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTabCode(YamlParser.TabCodeContext ctx);
}