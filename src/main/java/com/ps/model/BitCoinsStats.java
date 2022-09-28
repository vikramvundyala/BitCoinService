package com.ps.model;

import java.math.BigDecimal;
import java.util.List;

public class BitCoinsStats {

	private String iso;
    private String name;
    private String slug;
    private String ingestionStart;
    private String interval;
    private String src;
    private List<BigDecimal[]> entries;
    
	public String getIso() {
		return iso;
	}
	public void setIso(String iso) {
		this.iso = iso;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getIngestionStart() {
		return ingestionStart;
	}
	public void setIngestionStart(String ingestionStart) {
		this.ingestionStart = ingestionStart;
	}
	public String getInterval() {
		return interval;
	}
	public void setInterval(String interval) {
		this.interval = interval;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public List<BigDecimal[]> getEntries() {
		return entries;
	}
	public void setEntries(List<BigDecimal[]> entries) {
		this.entries = entries;
	}
    
}
