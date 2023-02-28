package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class SyntaxParser extends LexemeParser {
    /*------------------------------------------------------------------
     * PARSER RULES
     *------------------------------------------------------------------*/
    //    expr : plusminus* EOF ;
//
//    plusminus: multdiv ( ( '+' | '-' ) multdiv )* ;
//
//    multdiv : factor ( ( '*' | '/' ) factor )* ;
//
//    factor : func | unary | NUMBER | '(' expr ')' ;
//
//    unary : '-' factor
//
//    func : NAME '(' (expr (',' expr)+)? ')'

    public static int expr(LexemeBuffer lexemes) {
        Lexeme lexeme = lexemes.next();
        if (lexeme.type == LexemeType.EOF) {
            return 0;
        } else {
            lexemes.back();
            return plusminus(lexemes);
        }
    }

    public static int plusminus(LexemeBuffer lexemes) {
        int value = multdiv(lexemes);
        while (true) {
            Lexeme lexeme = lexemes.next();
            switch (lexeme.type) {
                case OP_PLUS:
                    value += multdiv(lexemes);
                    break;
                case OP_MINUS:
                    value -= multdiv(lexemes);
                    break;
                case EOF:
                case RIGHT_BRACKET:
                case COMMA:
                    lexemes.back();
                    return value;
                default:
                    throw new RuntimeException("Непредвиденный символ: " + lexeme.value
                            + " на позиции " + lexemes.getPos());
            }
        }
    }

    public static int multdiv(LexemeBuffer lexemes) {
        int value = factor(lexemes);
        while (true) {
            Lexeme lexeme = lexemes.next();
            switch (lexeme.type) {
                case OP_MUL:
                    value *= factor(lexemes);
                    break;
                case OP_DIV:
                    value /= factor(lexemes);
                    break;
                case EOF:
                case RIGHT_BRACKET:
                case COMMA:
                case OP_PLUS:
                case OP_MINUS:
                    lexemes.back();
                    return value;
                default:
                    throw new RuntimeException("Непредвиденный символ: " + lexeme.value
                            + " на позиции " + lexemes.getPos());
            }
        }
    }

    public static int factor(LexemeBuffer lexemes) {
        Lexeme lexeme = lexemes.next();
        switch (lexeme.type) {
            case FUNC:
                lexemes.back();
                return func(lexemes);
            case OP_MINUS:
                int value = factor(lexemes);
                return -value;
            case NUMBER:
                return Integer.parseInt(lexeme.value);
            case LEFT_BRACKET:
                value = plusminus(lexemes);
                lexeme = lexemes.next();
                if (lexeme.type != LexemeType.RIGHT_BRACKET) {
                    throw new RuntimeException("Непредвиденный символ: " + lexeme.value
                            + " на позиции " + lexemes.getPos());
                }
                return value;
            default:
                throw new RuntimeException("Непредвиденный символ: " + lexeme.value
                        + " на позиции " + lexemes.getPos());
        }
    }

    public static int func(LexemeParser.LexemeBuffer lexemeBuffer) {
        String funcName = lexemeBuffer.next().value;
        LexemeParser.Lexeme lexeme = lexemeBuffer.next();
        if (lexeme.type != LexemeParser.LexemeType.LEFT_BRACKET) {
            throw new RuntimeException("Неверный синтаксис вызова функции " + lexeme.value);
        }

        ArrayList<Integer> args = new ArrayList<>();

        lexeme = lexemeBuffer.next();
        if (lexeme.type != LexemeParser.LexemeType.RIGHT_BRACKET) {
            lexemeBuffer.back();
            do {
                args.add(expr(lexemeBuffer));
                lexeme = lexemeBuffer.next();

                if (lexeme.type != LexemeParser.LexemeType.COMMA && lexeme.type != LexemeParser.LexemeType.RIGHT_BRACKET) {
                    throw new RuntimeException("Неверный синтаксис вызова функции" + lexeme.value);
                }
            } while (lexeme.type == LexemeParser.LexemeType.COMMA);
        }
        return Function.getFunctionMap().get(funcName).apply(args);
    }
}
