

#include <WiFi.h>

#define LED_BUILTIN 2
#define SERIAL_RATE 9600
#define STD_DELAY_TIME 1000

bool repeaterIsOn = false, apIsOn = false, wifiIsConnected = false;
String _option; uint8_t option;
int networks_qtd;

typedef enum 
{
AP_ON = 1, AP_OFF = 2, 
WIFI_CONNECTED = 3, WIFI_NOT_CONNECTED = 4,
REPEATER_ON = 5, REPEATER_OFF = 6
} STATUS_ID;

typedef enum
{
MODE_NULL = 0, STA = 1,
AP = 2, APSTA = 3
} WIFI_MODE_ID;


const char* STATUS_TXT[] = 
{"", "AP IS ON", "AP IS OFF",
"WIFI CONNECTED", "WIFI NOT CONNECTED",
"REPEATER IS ON", "REPEATER IS OFF"};

const char* STATUS_WIFI_TXT[] =
{ "WL_IDLE_STATUS", "WL_NO_SSID_AVAIL",
"WL_SCAN_COMPLETED", "WL_CONNECTED",
"WL_CONNECT_FAILED", "WL_CONNECTION_LOST",
"WL_DISCONNECTED" };

const char* WIFI_MODE_TXT[] =
{ "WIFI_MODE_NULL, DESATIVED", "WIFI_MODE_STA, CLIENT",
"WIFI_MODE_AP, ACCESS POINT", "WIFI_MODE_APSTA, REPEATER" };


namespace Ap
{
    void enable()
    {
        if (!apIsOn)
        { apIsOn = WiFi.softAP(ap_ssid, ap_password); }
        Serial.println(STATUS_TXT[(apIsOn) ? STATUS_ID.AP_ON : STATUS_ID.AP_OFF]);
    }

    void disable()
    {
        if (apIsOn) { WiFi.softApdisconnect(); }
        Serial.println(STATUS_TXT[STATUS_ID.AP_OFF]); 
    }
}


namespace NetWork
{
    void status()
    { Serial.println(STATUS_WIFI_TXT[WiFi.status()]); }
    
    void getMode()
    { Serial.println(WIFI_MODE_TXT[WIFI_MODE_ID]); }

    void scan()
    {
        Serial.println("Scanning...");
        networks_qtd = WiFi.scanNetworks();

        if (networks_qtd == 0)
        { Serial.println("Networks not found"); }
        else
        {
            for (int i = 0; i < networks_qtd; i++)
            {
                Serial.printf
                ("%d: %s (%d dBm)\n", i+1, 
                WiFi.SSID(i).c_str(),
                WiFi.RSSI(i));
            }
        }
    }

    void connect()
    {
        if (wifiIsConnected)
        { Serial.println(STATUS_TXT[STATUS_ID.WIFI_CONNECTED] + "; Disconnect before"); }
        
        Serial.print("Type the network ssid: ");
        ssid = Serial.readString();
    
        Serial.print("\nType the network password: ");
        passkey = Serial.readString();
    
        WiFi.begin(ssid, passkey);
        if (WiFi.status() == WL_CONNECTED) { wifiIsConnected = true; }
        Serial.println(STATUS_WIFI_TXT[WiFi.status()]);
    }
    
    void disconnect()
    {
        if (wifiIsConnected)
        { WiFi.disconnect(); }
        Serial.println(STATUS_TXT[STATUS_ID.WIFI_NOT_CONNECTED]); }
    }
}


void repeaterMode(const bool op)
{
    if (op)
    {
        if (!repeaterIsOn)
        {
            if (!wifiIsConnected)
            { Serial.println(STATUS_TXT[STATUS_ID.WIFI_NOT_CONNECTED] + "Starting connect() ...\n"); Network::connect(); }
            if (!apIsOn)
            { Serial.println("Starting ap() ...\n"); Ap::enable(); }
        }
        else { return; }
    }
    else
    {
        Network::disconnect(); Ap::disable();
    }
}

void menu()
{
    Serial.println
    (
    STATUS_TXT[(wifiIsConnected) ? STATUS_ID.WIFI_CONNECTED : STATUS_ID.WIFI_NOT_CONNECTED] +
    STATUS_TXT[(repeaterIsOn) ? STATUS_ID.REPEATER_ON : STATUS_ID.REPEATER_OFF] +
    STATUS_TXT[(apIsOn) ? STATUS_ID.AP_ON : STATUS_ID.AP_OFF] +
    "\n\nEnter the option number:\n" +
    "[1] Get mode;\n" +
    "[2] Print Networks;\n" +
    "[3] Enable AP;\n" +
    "[4] Disable AP;\n" +
    "[5] Connect to network;\n" +
    "[6] Disconnect network;\n" + 
    "[7] Enable Repeater;\n" + 
    "[8] Disable Repeater;\n"
    );
    
    _option = Serial.readString();
    if (_option.length() > 1)
    { Serial.println("This requires just one char; Try again;"); return; }

    option = atoi(_option);
    switch(option)
    {
        case 1: Network::getMode(); break;
        case 2: Network::scan(); break;
        case 3: Ap::enable(); break;
        case 4: Ap::disable(); break;
        case 5: Network::connect(); break;
        case 6: Network::disconnect(); break;
        case 7: repeaterMode(true); break;
        case 8: repeaterMode(false); break;
        default: Serial.println("Invalid option;"); break;
    }
}

void setup()
{
    delay(STD_DELAY_TIME);
    pinMode(LED_BUITIN, OUTPUT);
    digitalWrite(LED_BUILTIN, HIGH);
    delay(STD_DELAY_TIME * 2);
    digitalWrite(LED_BUILTIN, LOW);
    for (int i = 1; i <= 2; i++)
    {
        digitalWrite(LED_BUILTIN, HIGH);
        delay(STD_DELAY_TIME/2);
        digitalWrite(LED_BUILTIN, LOW);
    }
    
    if (!Serial.available()) { return; }

    Serial.begin(9600);

    Serial.println(
    "WIFI UTILS (without antennas)" +
    "\nSerial rate: " + SERIAL_RATE);
}

void loop() { menu(); }