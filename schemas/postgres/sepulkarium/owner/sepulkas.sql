CREATE TABLE sepulkas (
	internal_id uuid UNIQUE,
	external_id character varying (64) UNIQUE,
	revision integer,
	created_at TIMESTAMP (6),
	updated_at TIMESTAMP (6)
);
