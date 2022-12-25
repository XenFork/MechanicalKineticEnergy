grammar Yaml;

options {
    language = Java;
}

@lexer::header {

}

@lexer::members {

public static int tab_ = 0;

public static void addTab() {
    tab_++;
}

public static void delTab() {
    tab_--;
}

public static int getspaceCount(String a) {
	int count = 0;
	for (char c : a.toCharArray()) {
		if (c == ' ') {
			count++;
		}
	}
	return count;
}

}
yaml: y+;
y: codeT | code | tabCode;
code: pre=ID': ' sub=ID;
codeT: tabs=TAB {
    var a = YamlLexer.getspaceCount($tabs.getText()) / 2;
    System.out.println(a);
} code;
tabCode: pre=ID (':' | ': ') tabs=TAB {
    var a = YamlLexer.getspaceCount($tabs.getText()) / 2;
    System.out.println(a);
}  (code | codeT | tabCode);
ID:[\u4e00-\u9fa5a-zA-Z0-9_]+;
LINE_COMMENT : '#' .*? '\n' -> skip;
WS: '\n' -> skip;
TAB: ' '+;