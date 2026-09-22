

#include "pass_manager.h"


int pass = 123;
static int secure_pass = 987654;


int get_secure_pass(void)
{ return secure_pass; }

void reset_secure_pass(int new_value)
{ secure_pass = new_value; }

static void set_secure_pass(int new_value)
{ secure_pass = new_value; }
