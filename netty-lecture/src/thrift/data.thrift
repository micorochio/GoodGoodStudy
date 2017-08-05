namespace java com.zing.netty.ssy.thrift.entity

typedef i16 short
typedef i32 int
typedef i64 long
typedef bool boolean
typedef string String

struct Person{
    1: optional String name,
    2: optional String address,
    3: optional String date
}

exception DataException{
    1:optional String message,
    2:optional String callStack,
    3:optional String date
}

service PersonService{
    Person getPerson(1:required String userName) throws (1:DataException dataException),
    void savePerson(1:required Person person) throws (1:DataException dataException),
}