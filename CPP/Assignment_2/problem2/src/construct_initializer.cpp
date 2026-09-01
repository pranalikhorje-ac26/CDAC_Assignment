#include<iostream>
using namespace std;

class Patient
{
private:
	int patientId;
	string name;
	int age;
	string ward;
	const string bloodGroup;

public:
	Patient();
	Patient(int id, const string& name);Patient(int id,const string& name, int age, const string& ward, const string& bg);

	~Patient();

	void displayRecord()const;
	void transferWard(const string& newWard);
};

Patient::Patient():patientId(0),name("Unknown"),age(0),ward("General"),bloodGroup("O+")
{
	cout << "[Constructor] Default patient registrated"<< endl;
}

Patient::Patient(int id,const string& name):patientId(id),name(name),age(0),ward("General"),bloodGroup("O+")
{
	cout << "[Constructor] Emergency: "<< name<<  endl;
}


Patient::Patient(int id,const string& name, int age,const string& ward, const string& bg): patientId(id), name(name), age(age),ward(ward), bloodGroup(bg)
{
	cout << "[Constructor] Full admission: "<< name<< endl;
}

Patient::~Patient()
{
	cout << "[Destructor]Patient "<< name << "Discharged" << endl;
}


void Patient::displayRecord()const
{
	cout<<"\nPatient record: "<<endl;
	cout<< "ID   :     "<< patientId <<endl;
	cout<< "Name   :     "<< name <<endl;
	cout<< "Age   :     "<< age <<endl;
	cout<< "Ward   :     "<< ward <<endl;
	cout<< "Blood group  :   "<< bloodGroup <<endl;
}

//transfer
void Patient::transferWard(const string& newWard)
{
	cout << "Ward transfer: Mayur Patil" << " --> " << newWard << endl;
	ward=newWard;
}



int main()
{
	Patient p1(1001,"Meera Joshi",34,"Cardiology","B+");
	Patient p2(1002,"Mayur Patil");
	Patient p3;
	p1.displayRecord();


	Patient* patients=new Patient[4];
	for(int i=0;i<4;i++)
	{
		patients[i].displayRecord();
	}

	patients[0].transferWard("ICU");

	delete[]patients;

	return 0;
}
