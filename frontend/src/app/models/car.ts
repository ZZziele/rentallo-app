export interface Pictures {
  mainPictureUrl: string,
  picturesUrls: string[]
}

export interface Car {
  id: number,
  model: string,
  brand: string,
  fuelType: string,
  engineType: string,
  bodyType: string,
  numberOfSeats: number,
  trunkCapacityInLitres: number,
  combustionPer100Km: string,
  bodySerialNumber: string,
  pricePerDayInPolishGrosz: number,
  available: boolean,
  rangeInKm: number,
  pictures: Pictures





}
