#include <Wire.h>
#include <Adafruit_SSD1306.h>

#define SCREEN_WIDTH 128
#define SCREEN_HEIGHT 32
Adafruit_SSD1306 display(SCREEN_WIDTH, SCREEN_HEIGHT, &Wire, -1);

void setup() {
  Wire.begin(21, 22); // SDA, SCL
  if(!display.begin(0x3C)) {
    Serial.println("Erro OLED");
  }
  display.display();
  display.clearDisplay();
}

void loop() {
  display.setCursor(0,0);
  display.print("Olá!");
  display.display();
  delay(1000);
}

