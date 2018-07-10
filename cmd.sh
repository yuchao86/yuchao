
netstat -n | awk '/^tcp/ {t[$NF]++}END{for(state in t){print state, t[state]} }'

