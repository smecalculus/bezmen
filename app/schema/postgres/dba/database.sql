DO $$
BEGIN
		PERFORM 'CREATE DATABASE ${bezmen.database}';
EXCEPTION WHEN duplicate_database THEN
		RAISE NOTICE 'Database "${bezmen.database}" already exist.';
END;
$$;
