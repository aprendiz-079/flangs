#include <iostream>

int main()
{
    int fahr, celsius;
    int lower, upper, step;
    
    lower = 0;
    upper = 300;
    step = 20;
    
    fahr = lower;
    
    do
    {
        celsius = 5 * (fahr - 32) /9;
        std::cout << fahr << '\t' << celsius << '\n' << std::endl;
        fahr = fahr + step;
    } while (fahr <= upper)

    return 0;
}