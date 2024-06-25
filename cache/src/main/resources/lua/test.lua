if redis.call("get",KEYS[1]) == ARGV[1] then
    return 1
else
    return 0
end