

#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>
#include <stdlib.h>

void self_update(char *new_path, char* argv[]) {
    pid_t pid = fork();

    if (pid < 0) { perror("fork"); exit(1); }

    if (pid == 0) { // FILHO = vira o novo programa
        // Troca esse processo pelo novo binário
        execv(new_path, argv);

        // Se chegou aqui deu ruim no exec
        perror("execv falhou");
        exit(127);
    }

    else { // PAI = processo antigo
        int status;
        sleep(2); // espera 2s pra ver se o novo crashou na hora

        if (waitpid(pid, &status, WNOHANG) == 0) {
            // Filho ainda ta vivo = deu bom
            printf("Update ok. Saindo...\n");
            exit(0); // Pai morre. Filho continua rodando
        } else {
            // Filho morreu = update quebrou
            printf("Novo binario crashou. Abortando update.\n");
        }
    }
}

int main(int argc, char *argv[]) {
    printf("Sou o processo %d\n", getpid());
    printf("Digite o caminho do novo binario: ");
    char path[256];
    scanf("%s", &path);

    self_update(path, argv); // argv pra passar os mesmos args pro novo

    while(1) { sleep(1); } // so chega aqui se falhou
}
