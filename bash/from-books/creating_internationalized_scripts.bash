
# I/O fds
0 = stdin
1 = stdout
2 = stderr

Exemples:
comando > arquivo.txt      # Redireciona stdout FD 1
comando 2> erros.txt       # Redireciona stderr FD 2
comando < entrada.txt      # Redireciona stdin FD 0
comando > tudo.txt 2>&1    # Junta stdout e stderr no mesmo arquivo
comando &> tudo.txt        # Atalho do bash pra cima
comando > /dev/null 2>&1   # Joga tudo fora

Usados pra extrair todas as strings do bash pra tradução.

--dump-strings = Gera arquivo .pot template
bash --dump-strings > bash_strings.pot

-D / --dump-po-strings = Gera arquivo .po completo com header
bash -D > bash_pt_BR.po

Saída exemplo:
#: shell.c:1234
msgid "command not found"
msgstr ""

Uso: Traduzir o msgstr "" e compilar com msgfmt pra gerar .mo
