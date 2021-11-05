import io
import re

def countchars(inputString):
    return len(inputString)

def countwords(inputString):
    return len(re.findall(r'\w+', inputString))