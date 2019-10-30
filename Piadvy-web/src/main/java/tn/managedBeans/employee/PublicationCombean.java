package tn.managedBeans.employee;

import tn.advyteam.entities.Commentairepub;
import tn.advyteam.entities.Publication;

public class PublicationCombean {
	
		private Publication publication ; 
		private Commentairepub commentairepub ;
		
		public Publication getPublication() {
			return publication;
		}
		public void setPublication(Publication publication) {
			this.publication = publication;
		}
		public Commentairepub getCommentairepub() {
			return commentairepub;
		}
		public void setCommentairepub(Commentairepub commentairepub) {
			this.commentairepub = commentairepub;
		}
		public PublicationCombean() {
			super();
		}
		public PublicationCombean(Publication publication, Commentairepub commentairepub) {
			super();
			this.publication = publication;
			this.commentairepub = commentairepub;
		}
		
		
	
}
