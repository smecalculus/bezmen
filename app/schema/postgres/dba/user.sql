DO $$
BEGIN
		CREATE USER ${bezmen.username} PASSWORD '${bezmen.password}';
EXCEPTION WHEN duplicate_object THEN
		RAISE NOTICE 'User ${bezmen.username} already exist.';
END
$$;
