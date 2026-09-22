

#include<iostream>
#include<string>

using namespace std;


void a(void);


int main(void)
{
  a();

  return 0;
}


void a(void)
{
  string in;

  cout << "type anything: ";

  cin >> in;

  cout << "u typed: " << in << endl;
}
