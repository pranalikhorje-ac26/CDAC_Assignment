#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;

class LogBuffer
{
    char* buffer;
    int capacity;
    int size;
    static int instanceCount;

public:

    // Constructor
    LogBuffer(int capacity);

    // Copy Constructor
    LogBuffer(const LogBuffer& other);

    // Copy Assignment Operator
    LogBuffer& operator=(const LogBuffer& other);

    // Destructor
    ~LogBuffer();

    // Other functions
    void append(const char* msg);
    void print() const;
    void clear();

    static int getInstanceCount();
};


// Initialize static member
int LogBuffer::instanceCount = 0;


// ================= CONSTRUCTOR =================

LogBuffer::LogBuffer(int capacity)
{
    this->capacity = capacity;
    size = 0;

    // +1 for '\0'
    buffer = new char[capacity + 1];

    // Initially empty string
    buffer[0] = '\0';

    instanceCount++;

    cout << "[LogBuffer Created] capacity=" << capacity << endl;
}


// ================= COPY CONSTRUCTOR =================

LogBuffer::LogBuffer(const LogBuffer& other)
{
    // Copy capacity and size
    capacity = other.capacity;
    size = other.size;

    // Allocate NEW memory
    buffer = new char[capacity + 1];

    // Deep copy
    memcpy(buffer, other.buffer, size + 1);

    instanceCount++;

    cout << "[LogBuffer Deep Copied] capacity=" << capacity << endl;
}


// ================= COPY ASSIGNMENT =================

LogBuffer& LogBuffer::operator=(const LogBuffer& other)
{
    // Self-assignment check
    if (this == &other)
    {
        cout << "[Self-assignment detected — no operation]" << endl;
        return *this;
    }

    // Release old memory
    delete[] buffer;

    // Copy data
    capacity = other.capacity;
    size = other.size;

    // Allocate new memory
    buffer = new char[capacity + 1];

    // Deep copy
    memcpy(buffer, other.buffer, size + 1);

    cout << "[LogBuffer Assigned]" << endl;

    return *this;
}


// ================= DESTRUCTOR =================

LogBuffer::~LogBuffer()
{
    delete[] buffer;

    instanceCount--;

    cout << "[LogBuffer Destroyed]" << endl;
}


// ================= APPEND =================

void LogBuffer::append(const char* msg)
{
    int msgLength = strlen(msg);

    // Calculate available space
    int available = capacity - size;

    // Copy only what can fit
    int copyLength = min(msgLength, available);

    memcpy(buffer + size, msg, copyLength);

    // Update size
    size += copyLength;

    // Add null terminator
    buffer[size] = '\0';
}


// ================= PRINT =================

void LogBuffer::print() const
{
    cout << buffer << endl;
}


// ================= CLEAR =================

void LogBuffer::clear()
{
    size = 0;
    buffer[0] = '\0';
}


// ================= GET INSTANCE COUNT =================

int LogBuffer::getInstanceCount()
{
    return instanceCount;
}


// ================= MAIN =================

int main()
{
    // Objective 1 : Basic usage

    LogBuffer log1(256);

    log1.append("Server started on port 8080");

    log1.append(" | Request received from 192.168.1.10");

    log1.print();


    // Objective 2 : Deep copy via copy constructor

    LogBuffer log2 = log1;

    log2.append(" | Cached response sent");

    cout << "log1 : ";
    log1.print();

    cout << "log2 : ";
    log2.print();


    // Objective 3 : Copy assignment operator

    LogBuffer log3(128);

    log3 = log1;

    cout << "log3 : ";
    log3.print();

    cout << "log1 : ";
    log1.print();


    // Objective 4 : Self-assignment guard

    log1 = log1;

    log1.print();


    // Objective 5 : Static member

    cout << "Live LogBuffer objects : "
         << LogBuffer::getInstanceCount()
         << endl;


    return 0;
}
