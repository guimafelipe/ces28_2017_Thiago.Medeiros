package refatoracao;
//package lod_antes;

public class School {
	public void register(Applicant applicant) {
		//TODO Auto-generated method stub		
	}
	
	public ApplicationResult recordNewApplication(Applicant newApplicant) {
		ApplicationResult retResult = new ApplicationResult();
		
		ApplicationValidation applicationValidation = this.getApplicationValidation();
		ApplicationDao admissionApplicationDao = this.getApplicationDao();
		
		boolean result = applicationValidation.validate(newApplicant);
		if (result) {
			result = admissionApplicationDao.persist(newApplicant);
			if (result) { // Note isSuccess() 
				retResult.setSuccess(true);
				retResult.setMessage("Admission application successful");
				this.register(newApplicant);
			} else {
				retResult.setSuccess(false);
				retResult.setMessage("Admission application fail");
			}
		} else {
			retResult.setSuccess(false);
			retResult.setMessage("Admission application fail");
		}
		
		return retResult;
	}

	public ApplicationDao getApplicationDao() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ApplicationValidation getApplicationValidation() {
		// TODO Auto-generated method stub
		return null;
	}
}