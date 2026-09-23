double getFillFraction()
{/*ALCODESTART::1790123340348*/
if (initialAmount <= 0) return 0;
double raw = amount / initialAmount;
raw = Math.max(0, Math.min(1, raw));
return Math.round(raw * 10) / 10.0;
/*ALCODEEND*/}

