

// Código para o ESP32 TRANSMISSOR
// Conexões:
// CE  -> GPIO5
// CSN -> GPIO4
// SCK -> GPIO18
// MOSI -> GPIO23
// MISO -> GPIO19

#include <SPI.h>
#include <nRF24L01.h>
#include <RF24.h>

#define CE_PIN 5
#define CSN_PIN 4

RF24 radio(CE_PIN, CSN_PIN);


const byte endereco[6] = "00001";


struct DadosTransmissao {
  int contador;
  float temperatura;
  int umidade;
  unsigned long timestamp;
};

DadosTransmissao dados;

void setup() {
  Serial.begin(115200);
  delay(1000);
  
  Serial.println("Iniciando Transmissor RF...");
  

  if (!radio.begin()) {
    Serial.println("ERRO: Módulo nRF24L01 não encontrado!");
    Serial.println("Verifique as conexões:");
    Serial.println("  CE  -> GPIO5");
    Serial.println("  CSN -> GPIO4");
    Serial.println("  VCC -> 3.3V");
    Serial.println("  GND -> GND");
    while (1) {
      delay(1000);
      Serial.print(".");
    }
  }
  

  radio.openWritingPipe(endereco);
  radio.setPALevel(RF24_PA_LOW);
  radio.setDataRate(RF24_250KBPS);
  radio.stopListening();
  
  Serial.println("Transmitter!");
  Serial.println("Sending data every 2s...");
  Serial.println("-----------------------------------");
}

void loop() {

  dados.contador++;
  dados.temperatura = random(200, 350) / 10.0;
  dados.umidade = random(300, 900) / 10.0;
  dados.timestamp = millis();
  

  bool sucesso = radio.write(&dados, sizeof(dados));
  
  if (sucesso) {
    Serial.print("[ENVIADO] #");
    Serial.print(dados.contador);
    Serial.print(" | Temp: ");
    Serial.print(dados.temperatura);
    Serial.print("°C | Umid: ");
    Serial.print(dados.umidade);
    Serial.println("%");
  } else {
    Serial.println("[FALHA] Não foi possível enviar os dados");
  }
  
  delay(2000);
}
