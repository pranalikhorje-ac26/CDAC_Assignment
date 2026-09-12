#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <cctype>
#include <stdexcept>

using namespace std;


// ============================================================
// PART A - ABSTRACT DATA PROCESSOR
// ============================================================

class DataProcessor
{
public:

    // Pure virtual functions
    // Every derived class MUST implement these functions

    virtual void loadData(const string& source) = 0;

    virtual void processData() = 0;

    virtual void exportResult(const string& destination) = 0;

    virtual string processorType() const = 0;

    virtual int recordCount() const = 0;


    // Non-pure virtual function
    // Base class provides a default summary format
    virtual void printSummary() const;


    // Virtual destructor
    virtual ~DataProcessor() = default;
};


// Definition of non-pure virtual function
void DataProcessor::printSummary() const
{
    cout << "Processor Type: " << processorType() << endl;
    cout << "Record Count: " << recordCount() << endl;
}


// ============================================================
// CSV PROCESSOR
// ============================================================

class CSVProcessor : public DataProcessor
{
private:

    vector<string> records;

public:

    // Load 5 sample CSV records
    void loadData(const string& source) override
    {
        cout << "Loading CSV data from: "
             << source << endl;

        records = {
            "alice,25,india",
            "bob,30,usa",
            "charlie,28,uk",
            "david,35,canada",
            "eva,22,germany"
        };
    }


    // Convert every record to uppercase
    void processData() override
    {
        for (string& record : records)
        {
            for (char& ch : record)
            {
                ch = static_cast<char>(toupper(ch));
            }
        }
    }


    // Export processed records
    void exportResult(const string& destination) override
    {
        cout << "[CSV EXPORT -> "
             << destination
             << "]" << endl;

        for (const string& record : records)
        {
            cout << record << endl;
        }
    }


    // Return processor type
    string processorType() const override
    {
        return "CSV Processor";
    }


    // Return number of records
    int recordCount() const override
    {
        return static_cast<int>(records.size());
    }
};


// ============================================================
// SENSOR STREAM PROCESSOR
// ============================================================

class SensorStreamProcessor : public DataProcessor
{
private:

    vector<double> readings;

    double mean = 0.0;
    double minimum = 0.0;
    double maximum = 0.0;

public:

    // Load 8 sensor readings
    void loadData(const string& source) override
    {
        cout << "Loading sensor data from: "
             << source << endl;

        readings = {
            23.4,
            21.8,
            25.1,
            24.6,
            22.9,
            26.3,
            23.7,
            24.2
        };
    }


    // Calculate mean, minimum and maximum
    void processData() override
    {
        if (readings.empty())
        {
            return;
        }

        double sum = 0.0;

        for (double value : readings)
        {
            sum += value;
        }

        mean = sum / readings.size();

        minimum = *min_element(
            readings.begin(),
            readings.end()
        );

        maximum = *max_element(
            readings.begin(),
            readings.end()
        );
    }


    // Export statistical result
    void exportResult(const string& destination) override
    {
        cout << "[SENSOR EXPORT -> "
             << destination
             << "]" << endl;

        cout << "Mean: " << mean << endl;
        cout << "Minimum: " << minimum << endl;
        cout << "Maximum: " << maximum << endl;
    }


    // Return processor type
    string processorType() const override
    {
        return "Sensor Stream Processor";
    }


    // Return number of readings
    int recordCount() const override
    {
        return static_cast<int>(readings.size());
    }


    // Getter required for Bonus
    double getMean() const
    {
        return mean;
    }
};


// ============================================================
// PART B - GENERIC DATA BUFFER<T>
// ============================================================

/*
    Template definitions are kept in this same file because
    the compiler needs to see the complete template definition
    when it creates DataBuffer<int>, DataBuffer<double>,
    DataBuffer<string>, etc.

    If the template implementation is placed separately in
    a .cpp file, the compiler may not be able to instantiate
    the required template versions, causing linker errors.
*/

template <typename T>
class DataBuffer
{
private:

    T* data;        // Heap-allocated array

    int capacity;   // Maximum number of elements

    int head;       // Index of oldest element

    int tail;       // Index where next element is written

    int count;      // Current number of elements


public:

    // Constructor
    DataBuffer(int capacity)
    {
        if (capacity <= 0)
        {
            throw invalid_argument(
                "Capacity must be greater than 0"
            );
        }

        this->capacity = capacity;

        data = new T[capacity];

        head = 0;
        tail = 0;
        count = 0;
    }


    // Destructor
    ~DataBuffer()
    {
        delete[] data;
    }


    // --------------------------------------------------------
    // PUSH
    // Add element.
    // If buffer is full, overwrite the oldest element.
    // --------------------------------------------------------

    void push(const T& value)
    {
        data[tail] = value;

        // Move tail circularly
        tail = (tail + 1) % capacity;


        if (count < capacity)
        {
            // Buffer was not full
            count++;
        }
        else
        {
            // Buffer was full
            // Move head because oldest element was overwritten
            head = (head + 1) % capacity;
        }
    }


    // --------------------------------------------------------
    // POP
    // Remove and return oldest element.
    // --------------------------------------------------------

    T pop()
    {
        if (isEmpty())
        {
            throw underflow_error("Buffer is empty");
        }

        T value = data[head];

        // Move head circularly
        head = (head + 1) % capacity;

        count--;

        return value;
    }


    // --------------------------------------------------------
    // PEEK
    // Return oldest element without removing it.
    // --------------------------------------------------------

    T peek() const
    {
        if (isEmpty())
        {
            throw underflow_error("Buffer is empty");
        }

        return data[head];
    }


    // --------------------------------------------------------
    // CHECK EMPTY
    // --------------------------------------------------------

    bool isEmpty() const
    {
        return count == 0;
    }


    // --------------------------------------------------------
    // CHECK FULL
    // --------------------------------------------------------

    bool isFull() const
    {
        return count == capacity;
    }


    // --------------------------------------------------------
    // SIZE
    // --------------------------------------------------------

    int size() const
    {
        return count;
    }


    // --------------------------------------------------------
    // FRIEND OUTPUT OPERATOR
    // Prints elements in logical order.
    // --------------------------------------------------------

    template <typename U>
    friend ostream& operator<<(
        ostream& out,
        const DataBuffer<U>& buf
    );
};


// ============================================================
// TEMPLATE FRIEND OPERATOR <<
// ============================================================

template <typename U>
ostream& operator<<(
    ostream& out,
    const DataBuffer<U>& buf
)
{
    out << "[";

    for (int i = 0; i < buf.count; i++)
    {
        // Circular index calculation
        int index =
            (buf.head + i) % buf.capacity;

        out << buf.data[index];

        if (i < buf.count - 1)
        {
            out << ", ";
        }
    }

    out << "]";

    return out;
}


// ============================================================
// MAIN
// ============================================================

int main()
{
    // ========================================================
    // PART A - POLYMORPHIC PIPELINE
    // ========================================================

    cout << "========================================" << endl;
    cout << "PART A - DATA PROCESSING PIPELINE" << endl;
    cout << "========================================" << endl;


    // DataProcessor is abstract, so this causes compile error:
    // DataProcessor dp;


    vector<DataProcessor*> pipeline;


    // Create derived objects on heap
    pipeline.push_back(new CSVProcessor());

    pipeline.push_back(new SensorStreamProcessor());


    // Runtime polymorphism
    for (auto* p : pipeline)
    {
        p->loadData("source_data");

        p->processData();

        p->printSummary();

        p->exportResult("output_dir");

        cout << "---" << endl;
    }


    // ========================================================
    // BONUS - DYNAMIC_CAST SAFETY CHECK
    // ========================================================

    cout << endl;
    cout << "========================================" << endl;
    cout << "BONUS - DYNAMIC CAST" << endl;
    cout << "========================================" << endl;


    /*
        dynamic_cast safely checks the actual object type
        at runtime.

        static_cast would be unsafe here because it does not
        perform a runtime type check.
    */

    for (auto* p : pipeline)
    {
        if (auto* csv =
            dynamic_cast<CSVProcessor*>(p))
        {
            cout << "Found CSV Processor with "
                 << csv->recordCount()
                 << " records."
                 << endl;
        }
        else if (auto* sensor =
                 dynamic_cast<SensorStreamProcessor*>(p))
        {
            cout << "Found Sensor Processor - Mean: "
                 << sensor->getMean()
                 << endl;
        }
    }


    // Delete heap objects
    for (auto* p : pipeline)
    {
        delete p;
    }

    pipeline.clear();


    // ========================================================
    // PART B - INTEGER DATA BUFFER
    // ========================================================

    cout << endl;
    cout << "========================================" << endl;
    cout << "PART B - DATA BUFFER" << endl;
    cout << "========================================" << endl;


    // Integer buffer - sensor tick IDs
    DataBuffer<int> tickBuffer(5);


    for (int i = 1; i <= 7; i++)
    {
        tickBuffer.push(i * 10);
    }


    cout << "Tick Buffer: "
         << tickBuffer
         << endl;


    // ========================================================
    // DOUBLE DATA BUFFER
    // ========================================================

    DataBuffer<double> tempBuffer(4);


    tempBuffer.push(36.6);
    tempBuffer.push(37.1);
    tempBuffer.push(38.2);
    tempBuffer.push(36.9);


    cout << "Before pop: "
         << tempBuffer
         << endl;


    cout << "Popped: "
         << tempBuffer.pop()
         << endl;


    cout << "After pop:  "
         << tempBuffer
         << endl;


    // ========================================================
    // STRING DATA BUFFER
    // ========================================================

    DataBuffer<string> logBuffer(3);


    logBuffer.push("INFO: Server started");

    logBuffer.push("WARN: High memory usage");

    logBuffer.push("ERROR: DB connection timeout");

    // This overwrites the oldest element
    logBuffer.push("INFO: Retry successful");


    cout << "Log Buffer: "
         << logBuffer
         << endl;


    // ========================================================
    // TEST EMPTY BUFFER EXCEPTION
    // ========================================================

    cout << endl;
    cout << "Testing empty buffer exception:" << endl;


    DataBuffer<int> emptyBuffer(3);


    try
    {
        emptyBuffer.pop();
    }
    catch (const underflow_error& e)
    {
        cout << "Exception: "
             << e.what()
             << endl;
    }


    // ========================================================
    // TEST PEEK
    // ========================================================

    cout << endl;
    cout << "Testing peek:" << endl;


    DataBuffer<int> peekBuffer(3);

    peekBuffer.push(100);
    peekBuffer.push(200);
    peekBuffer.push(300);


    cout << "Oldest element: "
         << peekBuffer.peek()
         << endl;


    cout << "Buffer after peek: "
         << peekBuffer
         << endl;


    return 0;
}
