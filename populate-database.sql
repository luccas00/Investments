-- Sample data for Investments database
-- Credit Card Networks
INSERT INTO credit_card_network (id, name, created_at, updated_at) VALUES
  ('430cb45a-06c9-440b-b76b-97114ad691a1', 'Visa', NOW(), NOW()),
  ('087a561e-dc73-4508-9030-db118040b44d', 'Mastercard', NOW(), NOW()),
  ('25810035-bfc6-4586-967a-e181b5209401', 'American Express', NOW(), NOW()),
  ('bde1cf5a-2620-407c-81b9-ea93ae76487c', 'Elo', NOW(), NOW()),
  ('a154ba86-46bc-4101-a9e0-cf195d7d3180', 'Discover', NOW(), NOW());

-- Users
INSERT INTO users (id, "key", name, cpf, phone, date_of_birth, email, password, user_type, status, created_at, updated_at) VALUES
  ('626ca6da-009c-4d10-9edb-70f0a2b23bae', '286c2db2-9bab-46e5-91e1-26d0d5160a19', 'Alice Silva', '12345678901', '+5511999991111', '1990-01-15 00:00:00', 'alice@example.com', 'password1', 0, 0, NOW(), NOW()),
  ('65bc5c74-3d7e-4da5-a3dd-8607db624de7', 'c29c594f-302e-4f8e-be70-8049930f061e', 'Bruno Souza', '23456789012', '+5511988882222', '1985-05-20 00:00:00', 'bruno@example.com', 'password2', 0, 0, NOW(), NOW()),
  ('40c7e07c-7051-4249-aff8-903809043470', 'ea489815-8edd-4efa-9d9e-46e14b3d51d9', 'Carla Pereira', '34567890123', '+5511977773333', '1992-07-30 00:00:00', 'carla@example.com', 'password3', 1, 0, NOW(), NOW()),
  ('a7c396c6-d794-44b4-89f5-fb3f82e30c9c', 'fdf8ad5a-51f3-49b0-afa5-980367b6e75d', 'Diego Costa', '45678901234', '+5511966664444', '1995-09-10 00:00:00', 'diego@example.com', 'password4', 0, 0, NOW(), NOW()),
  ('239e08c9-4141-4380-8cc9-6904ec5183e5', '56e14af6-2bf4-4794-bfd1-72f1091eba93', 'Eva Lima', '56789012345', '+5511955555555', '1998-12-05 00:00:00', 'eva@example.com', 'password5', 2, 0, NOW(), NOW());

-- Addresses
INSERT INTO address (id, user_id, zip_code, street, complement, neighborhood, city, state, region, uf, ddd, created_at, updated_at) VALUES
  ('f95862fc-ed12-43b9-8726-b5e9ce19d2bc', '626ca6da-009c-4d10-9edb-70f0a2b23bae', '01000-000', 'Rua A', 'Apto 1', 'Centro', 'São Paulo', 'SP', 'Sudeste', 'SP', '11', NOW(), NOW()),
  ('67e25428-bec8-4398-ab1f-ed41271d733c', '65bc5c74-3d7e-4da5-a3dd-8607db624de7', '20000-000', 'Rua B', 'Apto 2', 'Copacabana', 'Rio de Janeiro', 'RJ', 'Sudeste', 'RJ', '21', NOW(), NOW()),
  ('2ffd9ac5-b423-4855-b71f-894e84972943', '40c7e07c-7051-4249-aff8-903809043470', '30000-000', 'Av C', 'Sala 3', 'Savassi', 'Belo Horizonte', 'MG', 'Sudeste', 'MG', '31', NOW(), NOW()),
  ('87447943-eca9-4d2f-8ff8-0eb03d1640c1', 'a7c396c6-d794-44b4-89f5-fb3f82e30c9c', '40000-000', 'Rua D', 'Casa', 'Pelourinho', 'Salvador', 'BA', 'Nordeste', 'BA', '71', NOW(), NOW()),
  ('4a5bd7b3-2485-4374-b8df-f110a8a6f681', '239e08c9-4141-4380-8cc9-6904ec5183e5', '50000-000', 'Av E', 'Apto 5', 'Boa Viagem', 'Recife', 'PE', 'Nordeste', 'PE', '81', NOW(), NOW());

-- Credit Cards
INSERT INTO credit_card (id, user_id, credit_card_network_id, credit_card_number, cvc, owner, expiry_date, created_at, updated_at) VALUES
  ('e1dd2d00-da14-497d-91d1-f3138cc01670', '626ca6da-009c-4d10-9edb-70f0a2b23bae', '430cb45a-06c9-440b-b76b-97114ad691a1', '4111111111111111', 123, 'Alice Silva', '2026-12-31', NOW(), NOW()),
  ('edae6aeb-cdd9-4af4-932d-c4dc9f3ea043', '65bc5c74-3d7e-4da5-a3dd-8607db624de7', '087a561e-dc73-4508-9030-db118040b44d', '5555444433332222', 234, 'Bruno Souza', '2026-11-30', NOW(), NOW()),
  ('3148d62d-59ab-4e3c-a124-6ca1bf598dd7', '40c7e07c-7051-4249-aff8-903809043470', '25810035-bfc6-4586-967a-e181b5209401', '378282246310005', 345, 'Carla Pereira', '2026-10-31', NOW(), NOW()),
  ('5de89626-0eb0-40b4-a9b5-dcf6886c4226', 'a7c396c6-d794-44b4-89f5-fb3f82e30c9c', 'bde1cf5a-2620-407c-81b9-ea93ae76487c', '6362970000457013', 456, 'Diego Costa', '2025-09-30', NOW(), NOW()),
  ('d82d2d17-afce-4560-acb0-6ba534a15f3f', '239e08c9-4141-4380-8cc9-6904ec5183e5', 'a154ba86-46bc-4101-a9e0-cf195d7d3180', '6011111111111117', 567, 'Eva Lima', '2025-08-31', NOW(), NOW());

-- Wallets
INSERT INTO wallet (id, user_id, amount, balance, desempenho, total_quantity, total_invested, total_market_value, total_profit, total_profit_percent, created_at, updated_at) VALUES
  ('0412a800-8504-4055-9ff1-175c7c028753', '626ca6da-009c-4d10-9edb-70f0a2b23bae', 1000, 1030, 11.11, 10, 270.00, 300.00, 30.00, 11.11, NOW(), NOW()),
  ('0fde7501-383a-4ae3-a191-a85061edc940', '65bc5c74-3d7e-4da5-a3dd-8607db624de7', 500, 525, 7.69, 5, 325.00, 350.00, 25.00, 7.69, NOW(), NOW()),
  ('b9fa032c-395a-46c9-8ddc-0c975f18712a', '40c7e07c-7051-4249-aff8-903809043470', 2000, 2500, 25.00, 0.1, 2000.00, 2500.00, 500.00, 25.00, NOW(), NOW()),
  ('4d117ed4-53a1-4fe9-b45d-a1311433414a', 'a7c396c6-d794-44b4-89f5-fb3f82e30c9c', 100, 105, 5.00, 100, 100.00, 105.00, 5.00, 5.00, NOW(), NOW()),
  ('6b72e206-9933-45ac-9d84-bf09835ee409', '239e08c9-4141-4380-8cc9-6904ec5183e5', 500, 600, 20.00, 50, 500.00, 600.00, 100.00, 20.00, NOW(), NOW());

-- Investments
INSERT INTO investments (id, wallet_id, type, status, symbol, quantity, purchase_price, current_price, desempenho, indice, invested_amount, market_value, profit, profit_percent, relative_performance, purchase_date, created_at, updated_at) VALUES
  ('d3eca41d-1e8f-4d37-88a9-37134adef80c', '0412a800-8504-4055-9ff1-175c7c028753', 0, 2, 'PETR4', 10, 27.00, 30.00, 11.11, 5.00, 270.00, 300.00, 30.00, 11.11, 6.11, '2023-01-10 00:00:00', NOW(), NOW()),
  ('3dfa35ff-972d-4bf7-b374-9e1ed798f2b8', '0fde7501-383a-4ae3-a191-a85061edc940', 0, 2, 'VALE3', 5, 65.00, 70.00, 7.69, 3.00, 325.00, 350.00, 25.00, 7.69, 4.69, '2023-02-15 00:00:00', NOW(), NOW()),
  ('f0621af6-211b-4928-8e8c-ed16d709fee6', 'b9fa032c-395a-46c9-8ddc-0c975f18712a', 1, 2, 'BTC', 0.1, 20000.00, 25000.00, 25.00, 10.00, 2000.00, 2500.00, 500.00, 25.00, 15.00, '2023-03-20 00:00:00', NOW(), NOW()),
  ('d9f0af10-19d9-4a62-80d2-6b7faed2ad16', '4d117ed4-53a1-4fe9-b45d-a1311433414a', 3, 2, 'CDBXYZ', 100, 1.00, 1.05, 5.00, 2.00, 100.00, 105.00, 5.00, 5.00, 3.00, '2023-04-25 00:00:00', NOW(), NOW()),
  ('4708b8c7-c6bf-4270-a787-169527c1913f', '6b72e206-9933-45ac-9d84-bf09835ee409', 2, 2, 'FND11', 50, 10.00, 12.00, 20.00, 8.00, 500.00, 600.00, 100.00, 20.00, 12.00, '2023-05-05 00:00:00', NOW(), NOW());
