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
y: code | tabCode;
code: pre=ID': ' sub=ID;
tabCode: pre=ID (':' | ': ') tabs=TAB {
    var a = YamlLexer.getspaceCount($tabs.getText());
    System.out.println(a);
}  code;
ID:[a-zA-Z0-9_]+;
LINE_COMMENT : '#' .*? '\n' -> skip;
WS: '\n' -> skip;
TAB: ' '+;