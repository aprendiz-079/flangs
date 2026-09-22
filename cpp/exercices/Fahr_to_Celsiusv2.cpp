#include <iostream>
#define LOWER 0
#define UPPER 300
#define STEP 20

int main()
{
    float fahr;
    
    for (fahr = LOWER; fahr <= UPPER; fahr += STEP)
    {
        std::cout << fahr << '\t' << (5.0/9.0) * (fahr - 32) << '\n' << std::endl;
    }

    return 0;
}