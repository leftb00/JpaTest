package com.leftb.member.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="jpa_member")
@SequenceGenerator(
	name="JPA_MEMBER_SEQ_GEN",
	sequenceName="jpa_member_seq",
	initialValue=1,
	allocationSize=1
)

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Member {

	@Id @Column(name="mnum", nullable=false)
	@GeneratedValue(
		strategy=GenerationType.SEQUENCE,
		generator="JPA_MEMBER_SEQ_GEN")
	private Long mnum;

	@Column(name="mid", length=20, nullable=false)
	private String mid;

	@Column(name="mpw", length=20)
	private String mpw;

	@Column(name="mname", length=30, nullable=false)
	private String mname;

	@Column(name="mage")
	private int mage;
}
