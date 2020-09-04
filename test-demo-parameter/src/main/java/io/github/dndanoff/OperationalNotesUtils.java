package io.github.dndanoff;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OperationalNotesUtils {

	private final List<String> supportedTags;
	
	public OperationalNotesUtils(List<String> supportedTags) {
		this.supportedTags = supportedTags;
	}
	
	public Set<String> extractTagsFromOperationalNotes(String notesText){
		Set<String> tags = new HashSet<>();
		if(notesText == null || notesText.isEmpty()) {
			return tags;
		}

		String[] allTags = notesText.toUpperCase().trim().split("\\s+");  
		for(String tagStr : allTags) {
			for(String tag : supportedTags) {
				if(tagStr.equals(tag)) {
					tags.add(tag.replaceFirst("#", ""));
				}
			}
		}	

		return tags;
	}
}
