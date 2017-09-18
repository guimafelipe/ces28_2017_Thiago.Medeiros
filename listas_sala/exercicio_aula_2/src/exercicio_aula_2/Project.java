package exercicio_aula_2;

import java.util.Vector;

class Project {  
  protected int getNumberOfParticipants() { return participants.size(); }
  protected void setParticipants(Vector <Person> p) { participants = p; }
  protected Person getParticipant(int index) { return participants.elementAt(index); }
  
  boolean participate(Person p) {
	  for(int i = 0; i < this.getNumberOfParticipants(); i++)
	  { if (participants.elementAt(i).getId() == p.getId()) return (true); }
	  return (false);
  }

  private Vector <Person> participants;
}