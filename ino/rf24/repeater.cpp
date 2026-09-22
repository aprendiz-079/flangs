

// with antennas

#include <SPI.h>
#include <nRF24L01.h>
#include <RF24.h>
#include <WiFi.h>

#define BUILTIN_LED 2
#define SERIAL_RATE 9600

#define CE 5   // warning
#define CSN 17 // warning


RF24 radio_rx(CE, CSN);

RF24 radio_tx(CE, CSN);

const byte address[] = { 0xCA, 0xFE, 0xBA, 0xBE };

bool repeaterIsOn = false, apIsOn = false, wifiIsConnected = false;
uint8_t option;
int networks_qtd;

std::string ssid, password, ap_ssid, ap_password;

typedef enum
{
	AP_ON =                  1, 
	AP_OFF =                 2, 
	WIFI_CONNECTED =         3, 
	WIFI_NOT_CONNECTED =     4, 
	REPEATER_ON =            5, 
	REPEATER_OFF =           6
} STATUS_ID;

typedef enum
{
	MODE_NULL =              0, 
	STA =                    1, 
	AP =                     2, 
	APSTA =                  3
} WIFI_MODE_ID;

const char* STATUS_TXT[] = 
{"", "AP IS ON", "AP IS OFF",
"WIFI CONNECTED", "WIFI NOT CONNECTED",
"REPEATER IS ON", "REPEATER IS OFF"};

const char* STATUS_WIFI_TXT[] = 
{
	"WL_IDLE_STATUS", "WL_NO_SSID_AVAIL",
	"WL_SCAN_COMPLETED", "WL_CONNECTED",
	"WL_CONNECT_FAILED", "WL_CONNECTION_LOST",
	"WL_DISCONNECTED"
};

const char* WIFI_MODE_TXT[] = 
{
	"WIFI_MODE_NULL, DESATIVED", "WIFI_MODE_STA, CLIENT",
	"WIFI_MODE_AP, ACCESS POINT", "WIFI_MODE_APSTA, REPEATER"
};


void setup_reciver()
{
	radio_rx.setPALevel(RF24_PA_LOW);

	radio_tx.setPALevel(RF24_PA_LOW);

}

void setup_trasnmitter()
{
	radio_tx.openWritingPipe(address);
/*
RF24_PA_LOW    -1dbm
RF24_PA_MEDIUM  0dbm
RF24_PA_HIGH    1dbm uso de capacitor 10-40uF (micro farad)
quanto maior a potencia, maior o alcance e consumo de energia
*/
	radio_tx.setPALevel(RF24_PA_LOW);
/*
RF24_250KBPS
RF24_2MBPS
menor alcance, maior velocidade
*/
	radio_tx.setDataRate(RF24_2MBPS);
	radio_tx.stopListening();
}

namespace Network
{
	void scan()
	{
	
	}

	void connect()
	{
		while (Serial.available()) Serial.read();

		Serial.print("Enter tht ssid: ");
		ssid = Serial.readStringUntil('\n');

		Serial.print("\nEnter the password: ");
		password = Serial.readStringUntil('\n');
	}

	void disconnect()
	{
		(wifiIsConnected) ? WiFi.disconnect() : wifiIsConnected = false;
		Serial.println(STATUS_TXT[STATUS_ID.WIFI_NOT_CONNECTED]);
	}
}

void status()
{}

void menu()
{}

void main()
{
	delay(7000); // 7s
	Serial.begin(SERIAL_RATE);
}

void setup()
{ main(); }

void loop()
{}
